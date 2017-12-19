Feature: Plan a simple journey

  In order to get to waste less time in public transport
  As a Sydney commuter
  I want to know the quickest way to get between any two stations

  ![Flowchart](images/flowchart.png)

  @basic
  Scenario: Plan a basic journey
    Given that Sarah is a Sydney commuter
    When she plans a journey from Chatswood to Town Hall departing at 09:00 next MONDAY
    Then she should see that the first train departs at 09:00 and arrives at 09:21

  @basic
  Scenario: Plan another basic journey
    Given that Sarah is a Sydney commuter
    When she plans a journey from Chatswood to Town Hall departing at 09:00 next MONDAY
    Then she should see that the first train departs at 09:00 and arrives at 09:21

  @basic
  Scenario: Plan yet another basic journey
    Given that Sarah is a Sydney commuter
    When she plans a journey from Chatswood to Town Hall departing at 09:00 next MONDAY
    Then she should see that the first train departs at 09:00 and arrives at 09:21


  Scenario Outline: Plan many a journey
    Given that Connie is a Sydney commuter
    When she plans a journey from <departure> to <destination> departing at <plannedDepartureTime> next <departureDay>
    Then she should see that the first train departs at <departureTime> and arrives at <arrivalTime>
    Examples:
      | departure    | destination | plannedDepartureTime | departureDay | departureTime | arrivalTime |
      | Chatswood    | Town Hall   | 09:00                | MONDAY       | 09:00         | 09:21       |
      | Martin Place | Parramatta  | 09:00                | TUESDAY      | 08:57         | 09:36       |
