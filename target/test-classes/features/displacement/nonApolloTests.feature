@regression
Feature: Non Apollo - Choose your country links verifications

  Background:
    Given User navigates to 'https://storefront:afweb2017@lab.ashleyfurniture.com/' -Non Apollo
    And User scrolls down to footer - Non Apollo
    When User clicks on 'United States' link in footer next to USA flag - Non Apollo

  Scenario: TC-899575 [CYC] verify - Regions
    And User verifies url contains: 'choose-country-region/' - Non Apollo
    When User verifies availability of below regions - Non Apollo
      | Africa       |
      | Americas     |
      | Asia Pacific |
      | Europe       |
      | Middle East  |

  Scenario Outline: TC-899575 [CYC] verify - '<Country>'
    When User verifies '<Country>' flag is displayed
    Then User clicks on '<Country>' and verifies if it opens '<expected url>'
    Examples:
      | Country            | expected url                                 |
      | Kenya              | https://store.ashleyfurniturehomestore.co.ke/ |
      | South Africa       | https://ashleyfurniture.co.za/                |
      | Barbados           | https://store.ashleyfurniture.com.bb/         |
      | Belize             | https://store.ashleyfurniture.bz/             |
      | Canada             | https://ashleyhomestore.ca/                   |
      | Cayman Islands     | https://store.ashley.ky/                      |
      | Chile              | https://store.ashley.cl/                      |
      | USVI               | https://store.ashley.com.vi/                  |
      | Costa Rica         | https://store.ashley.cr/                      |
      | Dominican Republic | https://store.ashley.do/                      |
      | Ecuador            | https://www.ashleyfurniture.ec/               |
      | Guatemala          | https://www.ashley.gt/                        |
      | Honduras           | https://store.ashley.hn/                      |
      | Mexico             | https://ashleyfurniture.com.mx/               |
      | Panama             | https://store.ashley.com.pa/                  |
      | Puerto Rico        | https://ashleypr.com/                         |
      | United States      | https://www.ashleyfurniture.com/              |
      | Uruguay            | https://store.ashleyfurniture.uy/             |
      | Australia          | https://ashleyfurniture.com.au/               |
      | Bangladesh         | https://store.ashleyfurniture.com.bd/         |
      | Brunei             | https://store.ashleyfurniture.com.bn/         |
      | Cambodia           | https://store.ashleyfurniture.com.kh/         |
      | China              | https://ashley.cn/                            |
      | India              | https://store.ashleyfurniture.in/             |
      | Japan              | https://store.ashleyfurniture.jp/             |
      | Malaysia           | https://ashleyfurniture.com.my/               |
      | New Zealand        | https://ashleyfurniturestore.co.nz/           |
      | Philippines        | https://store.ashleyfurniture.ph/             |
      | Singapore          | https://shop.ashleyfurniture.sg/              |
      | South Korea        | https://ashleyfurniture.kr/                   |
      | Thailand           | https://store.ashleyfurniturehomestore.co.th/ |
      | Vietnam            | https://ashley.vn/                            |
      | Netherlands        | https://ashleyfurniturehomestore.nl/          |
      | Azerbaijan         | https://store.ashleyfurniture.az/             |
      | Bahrain            | https://store.ashleyfurniture.bh/           |
      | Iraq               | https://store.ashleyfurnitureiraq.com/        |
      | Saudi Arabia       | https://www.ashley.sa/                        |








