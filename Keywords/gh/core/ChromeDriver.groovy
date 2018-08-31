package gh.core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.WebDriver
//import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory

/**
 * @author gxu
 * 
 */
public class ChromeDriver {

	@Keyword
	def createChromeWebDriverCustomDownload(String downloadPath) {

		String projDir = RunConfiguration.getProjectDir()

		String downloadPdfPath = projDir + downloadPath;

		println downloadPdfPath;

		// add Chrome preferences
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
		chromePrefs.put("profile.default_content_settings.popups", 0)
		chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1)
		chromePrefs.put("download.default_directory", downloadPdfPath)
		chromePrefs.put("download.prompt_for_download", false)
		chromePrefs.put("download.directory_upgrade", true)
		chromePrefs.put("plugins.always_open_pdf_externally", true)

		// specify path to ChromeDriver
		System.setProperty("webdriver.chrome.driver", projDir + "/Drivers/BrowserDriver/chromedriver")
		ChromeOptions options = new ChromeOptions()
		options.setExperimentalOption("prefs", chromePrefs)

		// create web driver
		WebDriver driver = new ChromeDriver(options)

		// use your driver instead of default one
		DriverFactory.changeWebDriver(driver)

	}
}
