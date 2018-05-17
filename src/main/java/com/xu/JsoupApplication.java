package com.xu;

import com.xu.mybatis.Entity.Entity;
import com.xu.mybatis.service.EntityService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class JsoupApplication {
    public static void main(String[] args) throws IOException {
        int count=2;
        String filePath="result.txt";
        File file=new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }


        String URL="https://www.zhihu.com/explore/recommendations";
        Document document=Jsoup
                .connect(URL)
                .userAgent("Mozilla/5.0")
                .get();

        Elements elements=document.getElementsByClass("question_link");

        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(filePath,true));

        String resource="configuration.xml";
        Reader reader=Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(reader);
        SqlSession session=factory.openSession();
        EntityService ES=session.getMapper(EntityService.class);

        for(Element element:elements){
            String Url1=element.attr("abs:href");
            Document document1=Jsoup
                    .connect(Url1)
                    .userAgent("Mozilla/5.0")
                    .get();
            String QuestionHeaderTitle=
                    document1.getElementsByClass("QuestionHeader-title")
                            .first()
                            .text();
            String Description=
                    document1.getElementsByClass("QuestionHeader-detail")
                    .first()
                    .text();
            String  Answer=document1
                    .getElementsByClass("RichText ztext CopyrightRichText-richText")
                    .first()
                    .text();

            Entity entity=new Entity(count,Url1,QuestionHeaderTitle,Description,Answer);
            ES.insert(entity);

//            BufferedInputStream in =new BufferedInputStream(new FileInputStream(filePath));




//            out.write("\n".getBytes()+"链接".getBytes()+Url1.getBytes()
//            +"\n".getBytes()+"标题".getBytes()+": ".getBytes()+QuestionHeaderTitle.getBytes()
//            +"\n".getBytes()+"描述".getBytes()+": ".getBytes()+Description.getBytes()
//            +"\n".getBytes()+"回答".getBytes()+": ".getBytes()+Answer.getBytes()+"\n".getBytes());

            out.write("\n".getBytes());
            out.write("链接".getBytes());
            out.write(Url1.getBytes());
            out.write("\n".getBytes());
            out.write("标题".getBytes());
            out.write(": ".getBytes());
            out.write(QuestionHeaderTitle.getBytes());
            out.write("\n".getBytes());
            out.write("描述".getBytes());
            out.write(": ".getBytes());
            out.write(Description.getBytes());
            out.write("\n".getBytes());
            out.write("回答".getBytes());
            out.write(": ".getBytes());
            out.write(Answer.getBytes());
            out.write("\n".getBytes());
            System.out.print(
                    "\n"+"链接"+Url1
                    +"\n"+"标题"+": "+QuestionHeaderTitle
                    +"\n"+"描述"+": "+Description
                    +"\n"+"回答"+": "+Answer
                    +"\n"
            );

        }
        session.commit();
        session.close();
        out.close();
    }
}
