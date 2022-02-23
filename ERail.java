package week3.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {
	public static <ChormeDriver> void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("Tambaram",Keys.TAB);
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("Dindigul Jn",Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainNO = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int size = trainNO.size();
		System.out.println(size);
		for (int i = 1; i <=size; i++) {
			String text = driver.findElement(By.xpath("//div[@id='divTrainsList']//tr["+i+"]//td[1]")).getText();
			String text2 = driver.findElement(By.xpath("//div[@id='divTrainsList']//tr["+i+"]//td[2]")).getText();
			System.out.println("Train no: "+text);
			System.out.println("Train Name: "+text2);
			
		}
		
	}

}
