package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTests extends TestBase {
    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        Thread.sleep(2000);
        createCalendarEventsPage.repeat.click();

        Thread.sleep(3000);

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify if selected");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify is not selected");





    }
}
