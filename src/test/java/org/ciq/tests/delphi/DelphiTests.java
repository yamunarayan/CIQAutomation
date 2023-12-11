package org.ciq.tests.delphi;

import com.github.javafaker.Faker;
import org.ciq.pages.DelphiPage;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class DelphiTests extends BaseTest {
    DelphiPage delphiPage;

    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    WebDriver driver;
    String path = "./src/test/resources/testdata.xlsx";


    @Test(groups = {"delphiNavigation"})
    public void delphiNavigation() throws InterruptedException {

        data =excelUtils.getData("delphiNavigation", "delphi", path);
        driver = launchAppAndDelphiLogin("delphiUrl");
        delphiPage = new DelphiPage(driver);
        delphiPage.checkHomePage(data.get("HeaderName"), data.get("DashboardField"), data.get("DashboardLink"))
                .checkHomePageLink(data.get("LinkName1"),data.get("LinkName2"),data.get("LinkName3"),data.get("LinkName4"),data.get("LinkName5"))
                .navigateToApplications(data.get("LinkName1"),data.get("ApplicationsearchText"))
                .navigateToLocationThemes(data.get("LinkName2"),data.get("LocationText"),data.get("DataText"))
                .navigateToQuestions(data.get("LinkName3"),data.get("SurveyModuleText"))
                .navigateToSurveys(data.get("LinkName4"),data.get("SurveyModuleText"))
                .navigateToSurveyModules(data.get("LinkName5"), data.get("QuestionText"));
    }
}
