package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static JavascriptExecutor js;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:

			System.err.println("In-Valid Browser Type");
			break;
		}

	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void textSendByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void textSendByJS(WebElement element, String keysToSend) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
	}

	public void scroll(WebElement element, String scroll) {

		switch (scroll) {
		case "Up":
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		case "Down":
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		default:
			break;
		}

	}

	public void selectByValue(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element, String visibleText) {
	    Select s = new Select(element);
	    s.selectByVisibleText(visibleText);
	}

	public void screenCapture(String name) throws IOException {
		try {
		TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    
	    String folderPath = "C:\\Users\\admin\\Pictures\\Screenshots2\\";
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();  // Create directory if it doesn't exist
	    }
	    File target = new File(folderPath + name + ".png");
	    FileUtils.copyFile(source, target);
	    
	    System.out.println("Screenshot saved successfully.");
	} catch (IOException e) {
	    System.out.println("Error while saving screenshot: " + e.getMessage());
	}
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File("C:\\Users\\admin\\Pictures\\Screenshots2" + name + ".jpeg");
//		FileUtils.copyFile(source, target);
	}

	public String getWindowsID(int index) {

		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> li = new LinkedList<String>();
		li.addAll(allWindowsID);
		String childWindowsID = li.get(index);

		return childWindowsID;
	}
 

	public void switchWindows(String childWindowsID) {

		driver.switchTo().window(childWindowsID);
	}

	public String readExcel(int rownum, int cellnum) throws IOException {

		// To Locate Where Excel will be Located
		File file = new File("C:\\velu\\JavaEnt\\Framework\\New folder\\JD.xlsx");

		// To get File as a Input to the System(Tool)
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		// To Define Workbook / XSSFWorkbook || HSSFWorkBook
		Workbook book = new XSSFWorkbook(stream); // throws IOException

		// To get Sheet from Workbook
		Sheet sheet = book.getSheet("Sheet5");

		// To get Row Based on Index
		Row row = sheet.getRow(rownum);

		// To get Cell Based on Index
		Cell cell = row.getCell(cellnum);

		// To define Cell type
		CellType cellType = cell.getCellType();
		
		String value =null;

		switch (cellType) {
		case STRING:
			 value = cell.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				 value = simple.format(dateCellValue);
			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				 value = valueOf.toString();

			}
			break;

		default:
			System.out.println("In Valid Cell Type");
			break;
		}
		return value;

	}
	
	public boolean checkIsDisplayed(WebElement element) {
        boolean status = false;
        try {
            element.isDisplayed();
            status = true;
        } catch (NoSuchElementException e) {
            Reporter.log("The element " + element + " is entered is not available in DOM");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	public void mouseHover(WebElement element) {
        try {
            Actions action = new Actions(driver);  // Create Actions object
            action.moveToElement(element).perform();  // Perform mouse hover
            System.out.println("Mouse hovered over the element successfully.");
        } catch (Exception e) {
            System.err.println("Error while hovering over the element: " + e.getMessage());
        }
    }
	public void scrollToElement(WebElement element) {

        try {
            Actions actions = new Actions(driver);
            // Scroll to the WebElement
            actions.moveToElement(element).perform();

//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to the element successfully: " + element);
        } catch (Exception e) {
            System.out.println("Failed to scroll to the element: " + element);
            e.printStackTrace();
        }
    }
	public void handleConfirmationAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            
            // Get the text of the alert (useful for logging or validation)
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            
            // Perform action based on parameter (either "OK" or "Cancel")
            if (action.equalsIgnoreCase("accept")) {
                alert.accept();  // Clicks "OK" on the confirmation alert
            } else if (action.equalsIgnoreCase("dismiss")) {
                alert.dismiss();  // Clicks "Cancel" on the confirmation alert
            } else {
                System.out.println("Invalid action specified for confirmation alert.");
            }
        } catch (Exception e) {
            System.out.println("No confirmation alert present: " + e.getMessage());
        }
    }
	  

	
	
}
