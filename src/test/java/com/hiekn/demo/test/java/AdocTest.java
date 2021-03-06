package com.hiekn.demo.test.java;

import com.hiekn.demo.test.TestBase;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class AdocTest extends TestBase {
	
	@Test
	public void getAll(){
		
		 Properties props = System.getProperties();
		 props.list(System.out);

        Map<String, String> envs = System.getenv();
		for (Map.Entry<String, String> env : envs.entrySet()) {
			System.out.println(env.getKey() + " = " + env.getValue());
		}
		
	}

    @Test
    public void adoc() throws Exception{
//        Swagger2MarkupConverter.from("json" + "/swagger.json")
//                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
//                .build()
//                .intoFolder("doc");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withPathsGroupedBy(GroupBy.TAGS)
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withBasePathPrefix()
                .withGeneratedExamples()
                .build();

        Swagger2MarkupConverter.from(new URL("http://192.168.1.119:8888/api/swagger.json"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/generated"));
    }

}
