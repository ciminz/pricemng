package mybatis;

import org.junit.Test;
import org.mybatis.generator.api.ShellRunner;

import junit.framework.TestCase;

public class MybatisGenerator extends TestCase{
	public static void main(String[] args) {
		args = new String[] { "-configfile", "src\\test\\resources\\mybatis-generator-config.xml", "-overwrite" };
		ShellRunner.main(args);
	}
}
