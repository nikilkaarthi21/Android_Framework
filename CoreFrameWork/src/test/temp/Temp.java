import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Temp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Properties pr=new Properties();
		String path=System.getProperty("user.dir")+"//src//test//resources//project.properties";
		FileInputStream fs= new FileInputStream(path);
		try {
			pr.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pr.getProperty("application"));

	}

}
