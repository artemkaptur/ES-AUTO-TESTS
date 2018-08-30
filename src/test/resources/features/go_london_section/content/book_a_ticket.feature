Feature: Evening Standard "GO London" section - Content

  #As a user
  #I want to book tickets
  #So I can open article and click 'Find Tickets' button
  Scenario: I able to pick event
    Given I open "https://www.standard.co.uk/go/london/theatre/little-shop-of-horrors-review-triumphant-spectacle-pumps-an-infusion-of-new-blood-into-musical-a3909801.html"
    And I click 'Find Tickets' button
    Then 'Go London Tickets' page is opened

  #As a user
  #I want to book some tickets on some date in some time
  #So I can open article and book a two Lower Tier Left tickets in "Ticket" section on 30 August in 19:30
  Scenario Outline:I able to book a two Lower Tier Left tickets in "Ticket" section on 22 August in 19:30
    When I open "<article>"
    And I book "<number>" tickets on "<date>" in "<time>"
    Then information "<number> tickets", "<date>", "<time>" is right
    And 'Proceed to checkout' button is displayed
    And delete this ticket in 'Your Basket' page

    Examples:
      | number | article                                                                             | date        | time  |
      | 2      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 30-Aug-2018 | 19:30 |

  #As a user
  #I want to book some tickets on some date in some time and edit tickets number
  #So I can open article and book a two Lower Tier Left tickets in "Ticket" section on 30 August in 19:30 and edit number tickets by 1 after choose date
  Scenario Outline:
    When I open "<article>"
    And I book "<number>" tickets on "<date>" in "<time>" with edit number tickets by "<change_number>" in 'choose date' page
    Then information "<change_number> tickets", "<date>", "<time>" is right
    And delete this ticket in 'Your Basket' page

    Examples:
      | number | article                                                                             | date        | time  | change_number |
      | 2      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 30-Aug-2018 | 19:30 | 1             |

  #As a user
  #I want to book some tickets on some date in some time and edit tickets number
  #So I can open article and book a two Lower Tier Left tickets in "Ticket" section on 30 August in 19:30 and edit number tickets by 1 after choose seats
  Scenario Outline:
    When I open "<article>"
    And I book "<number>" tickets on "<date>" in "<time>" with edit number tickets by "<change_number>" in 'choose seats' page
    Then information "<change_number> tickets", "<date>", "<time>" is right
    And delete this ticket in 'Your Basket' page

    Examples:
      | number | article                                                                             | date        | time  | change_number |
      | 2      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 30-Aug-2018 | 19:30 | 1             |

  #As a user
  #I want to book some tickets on some date in some time and edit date
  #So I can open article and book a two Lower Tier Left tickets in "Ticket" section on 30 August in 19:30 and edit date by 31-Aug-2018 after choose seats
  Scenario Outline:
    When I open "<article>"
    And I book "<number>" tickets on "<date>" in "<time>" with edit date by "<change_date>" in 'choose seats' page
    Then information "<number> tickets", "<change_date>", "<time>" is right
    And delete this ticket in 'Your Basket' page

    Examples:
      | number | article                                                                             | date        | time  | change_date |
      | 2      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 30-Aug-2018 | 19:30 | 31-Aug-2018 |

  #As a user
  #I want to book some tickets on some date in some time and edit time
  #So I can open article and book a two Lower Tier Left tickets in "Ticket" section on 1 September in 19:30 and edit time by 14:30 after choose seats
  Scenario Outline:
    When I open "<article>"
    And I book "<number>" tickets on "<date>" in "<time>" with edit time by "<change_time>" in "<month>" in 'choose seats' page
    Then information "<number> tickets", "<date>", "<change_time>" is right
    And delete this ticket in 'Your Basket' page

    Examples:
      | number | article                                                                             | date        | time  | change_time | month          |
      | 2      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 01-Sep-2018 | 19:30 | 14:30       | September 2018 |

  #As a user
  #I want to see time in calendar
  #So I can open article and when book tickets click 'Show time' button in calendar to choose date
  Scenario Outline:
    When I open "<article>"
    And I open calendar to choose date
    And click 'Show time' button
    Then time information in calendar


    Examples:
      | article                                                                             |
      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon |

  #As a user
  #I want to Connect With 'Evening Standard GO London' when book tickets
  #So I can click label on Go London Tickets page
  Scenario Outline:
    When I open "<article>"
    And I click choose tickets number page
    And I click "<name>" label on choose tickets number page
    Then page with "<label_xpath>" to connect is opened

    Examples:
      | name      | article                                                                             | label_xpath                                     |
      | Twitter   | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | //a[text() = 'Evening Standard GO London']      |
      | Instagram | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | //h1[text() = 'Evening Standard GO London']     |
      | Facebook  | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | //span[text() = 'Evening Standard - GO London'] |
      | Email     | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | //label[text() = 'Email ']                      |

  #As a user
  #I want to book some tickets
  #So I can open article and book some tickets on same date and in some time
  Scenario Outline:
    Given I open "<article>"
    When I book "<number>" tickets
    Then information for book a tickets is right

    Examples:
      | article                                                                             | number |
      | https://www.eveningstandardtickets.co.uk/london-theatre/musicals/the-book-of-mormon | 2      |
