Feature: Evening Standard "GO London" section - Content

  #As a user
  #I want to book tickets
  #So I can open article and click 'Find Tickets' button
  Scenario: I able to pick event
    Given I open "https://www.standard.co.uk/go/london/theatre/little-shop-of-horrors-review-triumphant-spectacle-pumps-an-infusion-of-new-blood-into-musical-a3909801.html"
    And I click 'Find Tickets' button
    Then 'Go London Tickets' page is opened

  #As a user
  #I want to book some tickets on some date in some time and edit tickets number
  #So I can open article and book a some tickets on some date and in some time and edit number tickets by 1 after choose date
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I book some tickets with edit number tickets by "3" in 'choose date' page
    Then "edit number tickets by 1 in 'choose date' page" for book a tickets is right

  #As a user
  #I want to book some tickets on some date in some time and edit tickets number
  #So I can open article and book a some tickets on some date and in some time and edit number tickets by 1 after choose seats
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I book some tickets with edit number tickets by "1" in 'choose seats' page
    Then "edit number tickets by 1 in 'choose seats' page" for book a tickets is right

  #As a user
  #I want to book some tickets on some date in some time and edit date
  #So I can open article and book a some tickets on some date and in some time and edit date after choose seats
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I book some tickets with edit date in 'choose seats' page
    Then "edit date in 'choose seats' page" for book a tickets is right

  #As a user
  #I want to book some tickets on some date in some time and edit time
  #So I can open article and book a some tickets on some date and in some time and edit time after choose seats
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I book some tickets with edit time in 'choose seats' page
    Then "edit time in 'choose seats' page" for book a tickets is right

  #As a user
  #I want to see time in calendar
  #So I can open article and when book tickets click 'Show time' button in calendar to choose date
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I open calendar to choose date
    And click 'Show time' button
    Then time information in calendar

  #As a user
  #I want to Connect With Instagram 'Evening Standard GO London' when book tickets
  #So I can click label on Go London Tickets page
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I click choose tickets number page
    And I click "Instagram" label on choose tickets number page
    Then page with Instagram to connect is opened

  #As a user
  #I want to Connect Facebook With 'Evening Standard GO London' when book tickets
  #So I can click label on Go London Tickets page
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I click choose tickets number page
    And I click "Facebook" label on choose tickets number page
    Then page with Facebook to connect is opened

  #As a user
  #I want to Connect Twitter With 'Evening Standard GO London' when book tickets
  #So I can click label on Go London Tickets page
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I click choose tickets number page
    And I click "Twitter" label on choose tickets number page
    Then page with Twitter to connect is opened

  #As a user
  #I want to Connect Email With 'Evening Standard GO London' when book tickets
  #So I can click label on Go London Tickets page
  Scenario:
    When I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    And I click choose tickets number page
    And I click "Email" label on choose tickets number page
    Then page with Email to connect is opened

  #As a user
  #I want to book some tickets
  #So I can open article and book some tickets on same date and in some time
  Scenario:
    Given I open "https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon"
    When I book some tickets
    Then "I book some tickets" for book a tickets is right
    And 'Proceed to checkout' button is displayed
