package com.epam.esauto.steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.esauto.entity.Order;
import com.epam.esauto.spring.AppConfig;
import com.epam.esauto.util.DataHolder;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@ContextConfiguration(classes = AppConfig.class)
public class GoLondonPageSteps {

    private static final int TRIPLE_DEFAULT_TIMEOUT = 12000;
    private static final int NEW_DATE_IN_CALENDAR = 2;
    private static final int NUMBER_OF_PIXELS_FOR_SCROLL = 400;
    private static final int COORDINATE_Y = 0;
    private static final int COORDINATE_X = 0;
    private static final int COUNT_OF_LABEL_WITH_INFORMATION_ABOUT_TICKET = 3;
    private static final int MAIN_PAGE_NUMBER = 0;
    private static final String CHECK_COLOR_IN_BACKGROUND = "rgb(0, 0, 0)";
    private static final String NO_RESULT_MESSAGE = "Sorry, we couldn't find any results for your search, please select another option and try again";
    private static final String RESULT_MESSAGE = "We found %d results that match your search";
    private static final String BOOK_SOME_TICKETS_TEST_NAME = "I book some tickets";
    private static final String EDIT_TIME_IN_CHOOSE_SEATS_PAGE_TEST_NAME = "edit time in 'choose seats' page";
    private static final String EDIT_DATE_IN_CHOOSE_SEATS_PAGE_TEST_NAME = "edit date in 'choose seats' page";
    private static final String EDIT_NUMBER_TICKETS_IN_CHOOSE_SEATS_PAGE_TEST_NAME = "edit number tickets by 1 in 'choose seats' page";
    private static final String EDIT_NUMBER_TICKETS_IN_CHOOSE_DATE_PAGE_TEST_NAME = "edit number tickets by 1 in 'choose date' page";
    private static final String ARGUMENT_NAME = "argument";

    @Autowired
    private DataHolder dataHolder;

    @Value("${goLondonPage.url}")
    private String goLondonPageUrl;

    @Value("${goLondonPage.articleLink.xpath}")
    private String goLondonPageArticleXpath;

    @Value("${goLondonPage.articleLinkHref.xpath}")
    private String goLondonPageArticleHrefXpath;

    @Value("${goLondonArticlePage.facebookLogo.xpath}")
    private String goLondonArticlePageFacebookLogoXpath;

    @Value("${goLondonPage.background.xpath}")
    private String goLondonPageBackgroundXpath;

    @Value("${goLondonArticlePage.tags.xpath}")
    private String goLondonArticlePageTagsXpath;

    @Value("${goLondonArticlePage.findTicketButton.id}")
    private String goLondonArticlePageFindTicketButtonId;

    @Value("${goLondonTicketsPage.imgLogo.xpath}")
    private String goLondonTicketsPageImgLogoXpath;

    @Value("${goLondonPage.searchProperties.id}")
    private String goLondonPageSearchPropertiesId;

    @Value("${goLondonPage.account.id}")
    private String goLondonPageAccountId;

    @Value("${goLondonPage.fullMenu.id}")
    private String goLondonPageFullMenuId;

    @Value("${goLondonSearchPropertiesPage.label.id}")
    private String goLondonSearchPropertiesPageLabelId;

    @Value("${goLondonSearchPropertiesPage.iAmLokkingForSection.xpath}")
    private String goLondonSearchPropertiesPageIAmLokkingForSectionXpath;

    @Value("${goLondonSearchPropertiesPage.inSection.xpath}")
    private String goLondonSearchPropertiesPageInSectionXpath;

    @Value("${goLondonSearchPropertiesPage.thatSection.xpath}")
    private String goLondonSearchPropertiesPageThatSectionXpath;

    @Value("${goLondonSearchPropertiesPage.thatAreSection.xpath}")
    private String goLondonSearchPropertiesPageThatAreSectionXpath;

    @Value("${goLondonSearchPropertiesPage.andSection.xpath}")
    private String goLondonSearchPropertiesPageAndSectionXpath;

    @Value("${goLondonSearchPropertiesPage.inspireMeButton.xpath}")
    private String goLondonSearchPropertiesPageInspireMeButtonXpath;

    @Value("${goLondonSearchPropertiesPage.resultOfSearchLabel.className}")
    private String goLondonSearchPropertiesPageResultOfSearchLabelClassName;

    @Value("${goLondonSearchPropertiesPage.noResultOfSearchLabel.className}")
    private String goLondonSearchPropertiesPageNoResultOfSearchLabelClassName;

    @Value("${goLondonPage.goLondonPageLabel.xpath}")
    private String goLondonPageGoLondonPageLabelGpath;

    @Value("${goLondonPage.nameSectionLabel.xpath}")
    private String goLondonPageNameSectionLabelXpath;

    @Value("${goLondonPage.nameSectionPageLabel.xpath}")
    private String goLondonPageNameSectionPageLabelXpath;

    @Value("${goLondonPage.nameSubsectionLabel.xpath}")
    private String goLondonPageNameSubsectionLabelXpath;

    @Value("${goLondonTicketsPage.ticketsNumberSelect.xpath}")
    private String goLondonTicketsPageTicketsNumberSelectXpath;

    @Value("${goLondonTicketsPage.chooseDateNextButton.xpath}")
    private String goLondonTicketsPageChooseDateNextButtonXpath;

    @Value("${goLondonTicketsPage.seatsCircle.xpath}")
    private String goLondonTicketsPageSeatsCircleXpath;

    @Value("${goLondonTicketsPage.confirmSeatSelectionButton.xpath}")
    private String goLondonTicketsPageConfirmSeatSelectionButtonXpath;

    @Value("${goLondonTicketsPage.seatsInformationLabel.xpath}")
    private String goLondonTicketsPageSeatsInformationLabelXpath;

    @Value("${goLondonTicketsPage.ticketsNumberCheckLabel.xpath}")
    private String goLondonTicketsPageTicketsNumberCheckLabelXpath;

    @Value("${goLondonTicketsPage.dateCheckLabel.xpath}")
    private String goLondonTicketsPageDateCheckLabelXpath;

    @Value("${goLondonTicketsPage.timeCheckLabel.xpath}")
    private String goLondonTicketsPageTimeCheckLabelXpath;

    @Value("${goLondonTicketsPage.seatsCheckLabel.xpath}")
    private String goLondonTicketsPageSeatsCheckLabelXpath;

    @Value("${goLondonPage.labelForScrollToArticleLabel.className}")
    private String goLondonPageLabelForScrolToArticleLabelClassName;

    @Value("${goLondonTicketsPage.proceedToCheckout.id}")
    private String goLondonTicketsPageProceedToCheckoutId;

    @Value("${goLondonTicketsPage.deleteTicketButton.xpath}")
    private String goLondonTicketsPageDeleteTicketButtonXpath;

    @Value("${goLondonTicketsPage.confirmDeleteTicketButton.xpath}")
    private String goLondonTicketspageConfirmDeleteTicketButtonXpath;

    @Value("${goLondonTicketsPage.checkDeletedTicketLabel.xpath}")
    private String goLondonTicketsPageCheckDeletedTicketLabelXpath;

    @Value("${goLondonTicketsPage.editTicketNumberButton.xpath}")
    private String goLondonTicketsPageEditTicketNumberButtonXpath;

    @Value("${goLondonTicketsPage.editTicketDateButtonInChooseSeats.xpath}")
    private String goLondonTicketsPageEditTicketDateButtonInChooseSeatsXpath;

    @Value("${goLondonTicketsPage.editTicketDateLabelToScroll.xpath}")
    private String goLondonTicketsPageEditTicketDateLabelToScrollXpath;

    @Value("${goLondonTicketsPage.editTicketTimeButtonInChooseSeats.xpath}")
    private String goLondonTicketsPageEditTicketTimeButtonInChooseSeatsXpath;

    @Value("${goLondonTicketsPage.chooseYouTicketsButton.id}")
    private String goLondonTicketsPageChooseYouTicketsButtonId;

    @Value("${goLondonTicketsPage.showTimeButton.xpath}")
    private String goLondonTicketsPageShowTimeButtonXpath;

    @Value("${goLondonTicketsPage.timeLabelInCalendar.xpath}")
    private String goLondonTicketsPageTimeLabelInCalendarXpath;

    @Value("${goLondonTicketsPage.connectWithUsLabel.xpath}")
    private String goLondonTicketsPageConnectWithUsLabelXpath;

    @Value("${goLondonTicketsPage.connectWithUsLabelToScroll.xpath}")
    private String goLondonTicketsPageConnectWithUsLabelToScrollXpath;

    @Value("${goLondonTicketsPage.nameOfArticleLabel.xpath}")
    private String goLondonTicketsPageNameOfArticleLabelXpath;

    @Value("${goLondonTicketsPage.numberOfTicketsLabel.xpath}")
    private String goLondonTicketsPageNumberOfTicketsLabelXpath;

    @Value("${goLondonTicketsPage.showTimeLabelInAllDayInCalendar.xpath}")
    private String goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath;

    @Value("${goLondonTicketsPage.chooseFirstTimeLabelInCalendar.xpath}")
    private String goLondonTicketsPageChooseFirstTimeLabelInCalendarXpath;

    @Value("${goLondonTicketsPage.chooseSecondTimeLabelInCalendar.xpath}")
    private String goLondonTicketsPageChooseSecondTimeLabelInCalendarXpath;

    @Value("${goLondonTicketsPage.dataLabel.xpath}")
    private String goLondonTicketsPageDataLabelXpath;

    @Value("${goLondonTicketsPage.timeLabelTitle.xpath}")
    private String goLondonTicketsPageTimeLabelTitleXpath;

    @Value("${goLondonTicketsPage.checkNameOfArticleLabel.xpath}")
    private String goLondonTicketsPageCheckNameOfArticleLabelXpath;

    @Value("${goLondonArticlePage.scrollToFindTicketsButton.xpath}")
    private String goLondonArticlePageScrollToFindTicketsButtonXpath;

    @Value("${goLondonArticlePage.titleToCheck.xpath}")
    private String goLondonArticlePageTitleToCheckXpath;

    @Value("${goLondonTicketsPage.connectWithUsEmailLabel.xpath}")
    private String goLondonTicketsPageConnectWithUsEmailLabelXpath;

    @Value("${goLondonSearchPropertiesPage.countOfResultLabel.className}")
    private String goLondonSearchPropertiesPageCountOfResultLabelClassName;

    @Value("${goLondonTicketsPage.findTicketButton.xpath}")
    private String goLondonTicketsPageFindTicketButtonXpath;

    @Value("${goLondonTicketsPage.showTwoTimeLabelInAllDayInCalendar.xpath}")
    private String goLondonTicketsPageShowTwoTimeLabelInAllDayInCalendarXpath;

    @Value("${goLondonTicketsPage.informationLabelAboutOrder.xpath}")
    private String goLondonTicketsPageInformationLabelAboutOrderXpath;

    @Value("${goLondonTicketsPage.CheckingNeedToPressAgainLabelToWait.xpath}")
    private String goLondonTicketsPageCheckingNeedToPressAgainLabelToWaitXpath;

    @Value("${goLondonTicketsPage.checkInstagramLabel.xpath}")
    private String goLondonTicketsPageCheckInstagramLabelXpath;

    @Value("${goLondonTicketsPage.checkTwitterLabel.xpath}")
    private String goLondonTicketsPageCheckTwitterLabelXpath;

    @Value("${goLondonTicketsPage.checkFacebookLabel.xpath}")
    private String goLondonTicketsPageCheckFacebookLabelXpath;

    @Given("^I open the 'GO London' page$")
    public void iOpenTheGOLondonPage() {
        open(goLondonPageUrl);
    }

    @When("^I click footer \"([^\"]*)\"$")
    public void iClickLink(String footer) {
        $(By.linkText(footer)).click();
    }

    @Then("^privacy \"([^\"]*)\" is opened$")
    public void privacyPageIsOpened(String page) {
        $(By.linkText(page)).shouldBe();
    }

    @When("^I open article by click button$")
    public void iOpenArticleByClickButton() {
        dataHolder.put(ARGUMENT_NAME, $(By.xpath(goLondonPageArticleHrefXpath))
                .getWrappedElement()
                .getAttribute("href"));
        $(By.className(goLondonPageLabelForScrolToArticleLabelClassName)).scrollTo();
        $(By.xpath(goLondonPageArticleXpath)).click();
    }

    @Then("^page with article is opened$")
    public void pageWithArticleIsOpened() {
        assertEquals(WebDriverRunner.url(), dataHolder.getByKey(ARGUMENT_NAME));
    }

    @When("^I click facebook label in article page$")
    public void iClickFacebookLabelInArticlePage() {
        $(By.xpath(goLondonArticlePageFacebookLogoXpath)).click();
    }

    @Then("^background is black$")
    public void backgroundIsBlack() {
        $(By.xpath(goLondonPageBackgroundXpath))
                .shouldBe(cssValue("background-color", CHECK_COLOR_IN_BACKGROUND));
    }

    @And("^I open \"([^\"]*)\"$")
    public void iOpenSomeArticle(String article) {
        open(article);
    }

    @When("^I click \"([^\"]*)\" tag$")
    public void iClickTag(String tag) {
        int coordinateX = $(By.xpath(String.format(goLondonArticlePageTagsXpath, tag)))
                .getWrappedElement().getLocation().getY() - NUMBER_OF_PIXELS_FOR_SCROLL;
        executeJavaScript(String.format("window.scrollTo(%d,%d)", COORDINATE_Y, coordinateX));
        $(By.xpath(String.format(goLondonArticlePageTagsXpath, tag))).click();
    }

    @Then("^page with \"([^\"]*)\" is opened$")
    public void pageWithIsOpened(String label) {
        $(By.xpath(goLondonArticlePageTitleToCheckXpath)).shouldHave(text(label));
    }

    @And("^I click 'Find Tickets' button$")
    public void iClickFindTicketsButton() {
        $(By.xpath(goLondonArticlePageScrollToFindTicketsButtonXpath)).scrollTo();
        $(By.id(goLondonArticlePageFindTicketButtonId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @Then("^'Go London Tickets' page is opened$")
    public void goLondonTicketsPageIsOpened() {
        $(By.xpath(goLondonTicketsPageImgLogoXpath)).shouldBe(visible);
    }

    @When("^I click 'Search properties' button$")
    public void iClickSearchPropertiesButton() {
        $(By.id(goLondonPageSearchPropertiesId)).click();
    }

    @Then("^'Go London search properties' page is opened$")
    public void goLondonSearchPropertiesPageIsOpened() {
        $(By.id(goLondonSearchPropertiesPageLabelId)).shouldBe(visible);
    }

    @When("^I enter \"([^\"]*)\" section$")
    public void iEnterIMLookingForSection(String section) {
        $(By.xpath(goLondonSearchPropertiesPageIAmLokkingForSectionXpath)).selectOption(section);
    }

    @And("^enter \"([^\"]*)\" in 'in' section$")
    public void enterSection(String subsection) {
        $(By.xpath(goLondonSearchPropertiesPageInSectionXpath)).selectOption(subsection);
    }

    @And("^enter \"([^\"]*)\" in 'that \"([^\"]*)\"' section$")
    public void enterInThatSection(String name, String number) {
        $(By.xpath(String.format(goLondonSearchPropertiesPageThatSectionXpath, number))).selectOption(name);
    }

    @And("^enter \"([^\"]*)\" in 'that are' section$")
    public void enterInThatAreSection(String name) {
        $(By.xpath(goLondonSearchPropertiesPageThatAreSectionXpath)).selectOption(name);
    }

    @And("^enter \"([^\"]*)\" in 'and' section$")
    public void enterInAndSection(String name) {
        $(By.xpath(goLondonSearchPropertiesPageAndSectionXpath)).selectOption(name);
    }

    @And("^click 'INSPARE ME' button$")
    public void clickINSPAREMEButton() {
        $(By.xpath(goLondonSearchPropertiesPageInspireMeButtonXpath)).click();
    }

    @Then("^positive result search in search properties page is shown$")
    public void positiveResultSearchInSearchPropertiesPageIsShown() {
        $(By.className(goLondonSearchPropertiesPageResultOfSearchLabelClassName)).shouldBe(visible);
        $(By.className(goLondonSearchPropertiesPageResultOfSearchLabelClassName))
                .shouldHave(text(String.format(RESULT_MESSAGE,
                        $$(By.className(goLondonSearchPropertiesPageCountOfResultLabelClassName)).size())));
    }

    @Then("^negative result search in search properties page is shown$")
    public void negativeResultSearchInSearchPropertiesPageIsShown() {
        $(By.className(goLondonSearchPropertiesPageNoResultOfSearchLabelClassName)).shouldBe(visible);
        $(By.className(goLondonSearchPropertiesPageNoResultOfSearchLabelClassName)).shouldHave(text(NO_RESULT_MESSAGE));
    }

    @Then("^'GO London' page is opened$")
    public void goLondonPageIsOpened() {
        $(By.xpath(goLondonPageGoLondonPageLabelGpath)).shouldBe(visible);
    }

    @Then("^'GO' and 'London' have another color with hover action$")
    public void goAndLondonHaveAnotherColorWithHoverAction() {
        assertNotEquals($(By.xpath(goLondonPageGoLondonPageLabelGpath))
                .getCssValue("color"),
                $(By.xpath(goLondonPageGoLondonPageLabelGpath)).hover().getCssValue("color"));
    }

    @When("^I click \'toggle menu\' button$")
    public void iClickToggleMenuButton() {
        $(By.id(goLondonPageFullMenuId)).click();
    }

    @When("^I click \"([^\"]*)\" button$")
    public void iClickButton(String label) {
        $(By.xpath(String.format(goLondonPageNameSectionLabelXpath, label))).click();
    }

    @Then("^\"([^\"]*)\" label on new page is displayed$")
    public void labelOnNewPageIsDisplayed(String label) {
        $(By.xpath(goLondonPageNameSectionPageLabelXpath)).shouldHave(text(label));
    }

    @When("^I click \"([^\"]*)\" subsection in \"([^\"]*)\" section$")
    public void iClickSubsectionInSection(String link, String button) {
        $(By.xpath(String.format(goLondonPageNameSectionLabelXpath, button))).hover();
        $(By.xpath(String.format(goLondonPageNameSubsectionLabelXpath, link))).click();
    }

    @And("^'Proceed to checkout' button is displayed$")
    public void proceedToCheckoutButtonIsDisplayed() {
        $(By.id(goLondonTicketsPageProceedToCheckoutId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
    }

    @And("^I book some tickets with edit number tickets by \"([^\"]*)\" in 'choose date' page$")
    public void iBookTicketsOnInWithEditNumberTicketsByInChooseDatePage(String changeTickets) {
        Order order = new Order();
        order.setName($(By.xpath(goLondonTicketsPageNameOfArticleLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).getText());
        $(By.xpath(goLondonTicketsPageEditTicketNumberButtonXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $(By.xpath(goLondonTicketsPageTicketsNumberSelectXpath)).selectOption(changeTickets);
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageChooseDateNextButtonXpath)).click();
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last().click();
        checkingNeedToPressAgain($$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last());
        order.setDate($(By.xpath(goLondonTicketsPageDataLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        order.setTime($(By.xpath(goLondonTicketsPageTimeLabelTitleXpath)).getText());
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .doubleClick().click(COORDINATE_X, COORDINATE_Y);
        order.setSeats($(By.xpath(goLondonTicketsPageSeatsInformationLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        $(By.xpath(goLondonTicketsPageConfirmSeatSelectionButtonXpath)).click();
        dataHolder.put(EDIT_NUMBER_TICKETS_IN_CHOOSE_DATE_PAGE_TEST_NAME, order);
    }

    @And("^I book some tickets with edit number tickets by \"([^\"]*)\" in 'choose seats' page$")
    public void iBookTicketsOnInWithEditNumberTicketsByInChooseSeatsPage(String changeTickets) {
        Order order = new Order();
        order.setName($(By.xpath(goLondonTicketsPageNameOfArticleLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last().click();
        checkingNeedToPressAgain($$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last());
        order.setDate($(By.xpath(goLondonTicketsPageDataLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        order.setTime($(By.xpath(goLondonTicketsPageTimeLabelTitleXpath)).getText());
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        $(By.xpath(goLondonTicketsPageEditTicketNumberButtonXpath)).click();
        $(By.xpath(goLondonTicketsPageTicketsNumberSelectXpath)).selectOption(changeTickets);
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        $(By.xpath(goLondonTicketsPageChooseDateNextButtonXpath)).click();
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .doubleClick().click(COORDINATE_X, COORDINATE_Y);
        order.setSeats($(By.xpath(goLondonTicketsPageSeatsInformationLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageConfirmSeatSelectionButtonXpath)).click();
        dataHolder.put(EDIT_NUMBER_TICKETS_IN_CHOOSE_SEATS_PAGE_TEST_NAME, order);
    }

    @And("^I book some tickets with edit date in 'choose seats' page$")
    public void iBookTicketsOnInWithEditDateByInChooseSeatsPage() {
        Order order = new Order();
        order.setName($(By.xpath(goLondonTicketsPageNameOfArticleLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).click();
        checkingNeedToPressAgain($(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)));
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        $(By.xpath(goLondonTicketsPageEditTicketDateButtonInChooseSeatsXpath)).click();
        $(By.xpath(goLondonTicketsPageEditTicketDateLabelToScrollXpath)).scrollTo();
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).get(NEW_DATE_IN_CALENDAR).click();
        checkingNeedToPressAgain($$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath))
                .get(NEW_DATE_IN_CALENDAR));
        order.setDate($(By.xpath(goLondonTicketsPageDataLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        order.setTime($(By.xpath(goLondonTicketsPageTimeLabelTitleXpath)).getText());
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .doubleClick().click(COORDINATE_X, COORDINATE_Y);
        order.setSeats($(By.xpath(goLondonTicketsPageSeatsInformationLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        $(By.xpath(goLondonTicketsPageConfirmSeatSelectionButtonXpath)).click();
        dataHolder.put(EDIT_DATE_IN_CHOOSE_SEATS_PAGE_TEST_NAME, order);
    }

    @And("^I book some tickets with edit time in 'choose seats' page$")
    public void iBookTicketsOnInWithEditTimeByInChooseSeatsPage() {
        Order order = new Order();
        order.setName($(By.xpath(goLondonTicketsPageNameOfArticleLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).getText());
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $$(By.xpath(goLondonTicketsPageShowTwoTimeLabelInAllDayInCalendarXpath)).last().click();
        $(By.xpath(goLondonTicketsPageChooseFirstTimeLabelInCalendarXpath)).click();
        $(By.id(goLondonTicketsPageChooseYouTicketsButtonId)).click();
        checkingNeedToPressAgainWhenEditTime($(By.xpath(goLondonTicketsPageChooseFirstTimeLabelInCalendarXpath)));
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        $(By.xpath(goLondonTicketsPageEditTicketTimeButtonInChooseSeatsXpath))
                .waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT).click();
        $(By.xpath(goLondonTicketsPageChooseSecondTimeLabelInCalendarXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $(By.id(goLondonTicketsPageChooseYouTicketsButtonId)).click();
        checkingNeedToPressAgainWhenEditTime($(By.xpath(goLondonTicketsPageChooseSecondTimeLabelInCalendarXpath)));
        order.setDate($(By.xpath(goLondonTicketsPageDataLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        order.setTime($(By.xpath(goLondonTicketsPageTimeLabelTitleXpath)).getText());
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .doubleClick().click(COORDINATE_X, COORDINATE_Y);
        order.setSeats($(By.xpath(goLondonTicketsPageSeatsInformationLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageConfirmSeatSelectionButtonXpath)).click();
        dataHolder.put(EDIT_TIME_IN_CHOOSE_SEATS_PAGE_TEST_NAME, order);
    }

    private void checkingNeedToPressAgainWhenEditTime(SelenideElement selenideElement) {
        $(By.xpath(goLondonTicketsPageCheckingNeedToPressAgainLabelToWaitXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        if ($$(By.xpath(goLondonTicketsPageInformationLabelAboutOrderXpath)).size() < COUNT_OF_LABEL_WITH_INFORMATION_ABOUT_TICKET) {
            selenideElement.scrollTo().click();
            $(By.id(goLondonTicketsPageChooseYouTicketsButtonId)).click();
        }
    }

    private void checkingNeedToPressAgain(SelenideElement selenideElement) {
        $(By.xpath(goLondonTicketsPageCheckingNeedToPressAgainLabelToWaitXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        if ($$(By.xpath(goLondonTicketsPageInformationLabelAboutOrderXpath)).size() < COUNT_OF_LABEL_WITH_INFORMATION_ABOUT_TICKET)
            selenideElement.click();
    }

    @And("^I open calendar to choose date$")
    public void iOpenCalendarToChooseDate() {
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
    }

    @And("^click 'Show time' button$")
    public void clickShowTimeButton() {
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @Then("^time information in calendar$")
    public void timeInformationInCalendar() {
        $(By.xpath(goLondonTicketsPageTimeLabelInCalendarXpath)).shouldBe(visible);
    }

    @And("^I click choose tickets number page$")
    public void iClickChooseTicketsNumberPage() {
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
    }

    @And("^I click \"([^\"]*)\" label on choose tickets number page$")
    public void iClickLabelOnChooseTicketsNumberPage(String name) {
        $(By.xpath(goLondonTicketsPageConnectWithUsLabelToScrollXpath)).scrollTo();
        $(By.xpath(String.format(goLondonTicketsPageConnectWithUsLabelXpath, name))).click();
    }

    @Then("^page with Instagram to connect is opened$")
    public void pageWithInstagramToConnectIsOpenedAndTitle() {
        switchTo().window("Evening Standard GO London (@esgolondon) • Instagram photos and videos");
        $(By.xpath(goLondonTicketsPageCheckInstagramLabelXpath))
                .waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT).shouldBe(visible);
        close();
        switchTo().window(MAIN_PAGE_NUMBER);
    }

    @Then("^page with Email to connect is opened$")
    public void pageWithEmailToConnectIsOpened() {
        $(By.xpath(goLondonTicketsPageConnectWithUsEmailLabelXpath)).shouldBe(visible);
    }

    @Then("^page with Twitter to connect is opened$")
    public void pageWithTwitterToConnectIsOpened() {
        switchTo().window("Evening Standard GO London (@ESGoLondon) | Twitter");
        $(By.xpath(goLondonTicketsPageCheckTwitterLabelXpath))
                .waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT).shouldBe(visible);
        close();
        switchTo().window(MAIN_PAGE_NUMBER);
    }

    @Then("^page with Facebook to connect is opened$")
    public void pageWithFacebookToConnectIsOpened() {
        switchTo().window("Evening Standard - GO London - Home | Facebook");
        $(By.xpath(goLondonTicketsPageCheckFacebookLabelXpath))
                .waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .shouldBe(visible);
        close();
        switchTo().window(MAIN_PAGE_NUMBER);
    }

    @When("^I book some tickets$")
    public void iBookTickets() {
        Order order = new Order();
        order.setName($(By.xpath(goLondonTicketsPageNameOfArticleLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageFindTicketButtonXpath)).click();
        order.setTickets($(By.xpath(goLondonTicketsPageNumberOfTicketsLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        $(By.xpath(goLondonTicketsPageShowTimeButtonXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
        $$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last().click();
        checkingNeedToPressAgain($$(By.xpath(goLondonTicketsPageShowTimeLabelInAllDayInCalendarXpath)).last());
        order.setDate($(By.xpath(goLondonTicketsPageDataLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).getText());
        order.setTime($(By.xpath(goLondonTicketsPageTimeLabelTitleXpath)).getText());
        $(By.xpath(goLondonTicketsPageSeatsCircleXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .doubleClick().click(COORDINATE_X, COORDINATE_Y);
        order.setSeats($(By.xpath(goLondonTicketsPageSeatsInformationLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageConfirmSeatSelectionButtonXpath)).click();
        dataHolder.put(BOOK_SOME_TICKETS_TEST_NAME, order);
    }

    @Then("^\"([^\"]*)\" for book a tickets is right$")
    public void informationForBookATicketsIsRight(String testName) {
        Order checkOrder = new Order();
        checkOrder.setName($(By.xpath(goLondonTicketsPageCheckNameOfArticleLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .getText());
        checkOrder.setTickets($(By.xpath(goLondonTicketsPageTicketsNumberCheckLabelXpath)).getText());
        checkOrder.setDate($(By.xpath(goLondonTicketsPageDateCheckLabelXpath)).getText());
        checkOrder.setTime($(By.xpath(goLondonTicketsPageTimeCheckLabelXpath)).getText());
        checkOrder.setSeats($(By.xpath(goLondonTicketsPageSeatsCheckLabelXpath)).getText());
        $(By.xpath(goLondonTicketsPageDeleteTicketButtonXpath)).click();
        $(By.xpath(goLondonTicketspageConfirmDeleteTicketButtonXpath)).click();
        $(By.xpath(goLondonTicketsPageCheckDeletedTicketLabelXpath))
                .waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT);
        close();
        assertEquals(checkOrder, dataHolder.getByKey(testName));
    }

    @Then("^'user menu' and 'search' button place on same line$")
    public void userMenuAndSearchButtonPlaceOnSameLine() {
        assertEquals($(By.id(goLondonPageSearchPropertiesId))
                        .getWrappedElement().getLocation().getY(),
                $(By.id(goLondonPageAccountId)).getWrappedElement().getLocation().getY());

    }
}