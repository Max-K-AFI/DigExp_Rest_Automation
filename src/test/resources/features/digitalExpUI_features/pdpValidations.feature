@regression
Feature: PDP page items verification

#  Background:
#    Given  User navigates to 'https://mfe-product.dev.ashleyretail.com/product-details/1140238'
#
#  Scenario: TC-839606 [PDP] Downloading Product Assembly Instructions
#    Given User navigates to 'https://mfe-product.dev.ashleyretail.com/product-details/EW0440-168'
#    And User clicks on 'Download PDF' link to get instructions
#    Then User should see new Tab opening with download link
#
#  Scenario: TC-839607 [PDP] Verify Product Modal Image in popup
#    When User clicks on main Zardoni Sofa image
#    And User verifies popup window image includes 'Zardoni Sofa'
#
#  Scenario: TC-844159 [PDP] Hero Image placeholder
#    And User verifies title holds: 'Zardoni Sofa'
#    When User verifies by default on page load it will be the first image in the image set
#    When User verifies the location of Hero image placeholder
#    Then User verifies the location of image thumbnails
#
#  Scenario: TC-881482 [PDP] Verify 'Collections Scrolling Modal'
#    And User clicks on 'Shop the Zardoni Collection' link
#    When User verifies scrolling modal X-close icon and collection name: 'Zardoni' displayed
#    When User verifies list of product names and prices
#    Then User clicks on X-close to close the scrolling modal
#
#  Scenario: TC-881470 [PDP] Product overview Modal
#    And User clicks on 'product overview' text link
#    When User verifies X-close icon, 'product overview' title, 'Description' title are displayed
#    When User verifies Description text is present
#    Then User clicks on X-close to close the scrolling modal
#
#  Scenario: TC-881450 [PDP] 'Add to Cart' Confirmation Scrolling Modal
#    And User clicks on 'Add To Cart' by name
#    When User verifies availability of scrolling modal elements
#    When User verifies frequently bought together title and elements
#    Then User clicks on X-close to close the scrolling modal
#
#    #OPEN RD IN PLACE FOR FAILURE: not available on UI!!!
##  Scenario: TC-888530 [PDP] View Variant(Size) Options on PDP
##    And User verifies "Size" options are available on page
##    Then User verifies the correct updates of size value fields
##      | Twin        |
##      | Twin XL     |
##      | Full        |
##      | Queen       |
##      | King        |
##      | Calif. King |
#
#  Scenario: TC-888531 [PDP] Verify Number of Images and Expand Icon for Image Set on PDP
#    When User verifies presence of available image Numbers and Expand image icon
#    And User verifies functionality of numbers in set of numbers shown
#    And User verifies clicking on numbers shows correct image from given set of images

    ########################### ABOVE THIS LINE ARE OLD - APOLLO TEST CASES ############################

  Scenario: Verify image Set Thumbnails on the PDP
    Given User navigates to "https://mfe-product.dev.ashleyretail.com/product-details/1140238"
    When User verifies thumbnail images set on right of hero image are displayed
    And User verifies amount of thumbnail images shown are 3
    And User verifies additional images are shown with '+#' under 3rd image
    When User hovers over on each thumbnail image which changes and shows as Hero image
    Then User clicks on thumbnail image and sees selected image as Hero slot in opened image modal


