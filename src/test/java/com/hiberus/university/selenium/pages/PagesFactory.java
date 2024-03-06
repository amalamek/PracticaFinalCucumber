package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;


public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;
  private  final StorePage StorePage;

  private  final CannonPage CannonPage;
  private final ApplePage ApplePage;
  private final RegistrationPage RegistrationPage;
  private final LoginPage LoginPage;

  private final CheckoutPage CheckoutPage;



  private PagesFactory(WebDriver driver) {
    this.driver = driver;

       StorePage=new StorePage(driver);
       CannonPage=new CannonPage(driver);
       ApplePage=new ApplePage(driver);
       RegistrationPage=new RegistrationPage(driver);
       LoginPage=new LoginPage(driver);
       CheckoutPage=new CheckoutPage(driver);

  }

  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }

  public static PagesFactory getInstance() {
    return pagesFactories;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public StorePage getStorePage(){return StorePage;}

  public CannonPage getCannonPage(){return CannonPage;}

  public ApplePage getApplePage(){return ApplePage;}
  public RegistrationPage getRegistrationPage(){return RegistrationPage;}

  public LoginPage getLoginPage(){return LoginPage;}
  public CheckoutPage getCheckoutPage(){return CheckoutPage;}



}
