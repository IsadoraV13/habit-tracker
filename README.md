# habit-tracker
Simple habit tracker


### Habits
- A habitName is defined by the user (in their own words) 
- A habit has a number of points (user defined) based on how easy or not the user thinks it is to accomplish it
- the points will determine the reward level every time the habit is accomplished
- Option to habit stack for habits that are 1 or 2 points  
&nbsp; 

Quick note:
- all habits will be created with a default Reward level
- when it is accomplished the first time, the reward will be incremented by the difficulty points (think about this)


### Themes
- A theme cannot exist without a user (it user defined and specific to that user)
- 
  &nbsp;

How does a user use the app?
- create a habit:
  - name (open form answer, character limit?)
  - adds/creates a theme (an overarching goal that several habits relate to, e.g. health or career)
  - adds a streakFrequency - how often do they aim to perform the Habit (daily, weekly) - monthly is too infrequent
    - stretch: number of times per day, per week
  - assign difficultyPoints (how hard is it to perform the habit once)
- adding a theme:
    - if the theme does not exist, they can add/create a new one
    - if the theme already exists, they will be able to select it from a drop down (UI)
    - means that when user clicks drop down, there will be a call to BE to retrieve all themes for that user
    - what is a theme? 
- in the background, for every new habit, an L0 reward is added.
    - an L1 is earned every time a habit is completed for the first time
- a difficulty point is a multiplier on the reward:
    - if an easy habit is completed, the multiplier is 1
    - if a hard habit is completed, the multiplier is 3
- xxx
- Score:
    - Counter starts at 0
    - When performed first time, counter goes to 1, and streak counts from then. If streak breaks, counter drops to 0 
    - Level 1 (performed once)
      - L1 + DiffPt1 =  2
      - L1 + DiffPt2 =  3
      - L1 + DiffPt3 =  5 
    - Level 2 (performed 3 times)
      - L2 + DiffPt1 =  previous + 0
      - L2 + DiffPt2 =  previous + 3
      - L2 + DiffPt3 =  previous + 5
    - Level 3 (performed more than 3 times)
      - L3 + DiffPt1 + NoStreak =  previous + 1
      - L3 + DiffPt2 + NoStreak =  previous + 2
      - L3 + DiffPt3 + NoStreak =  previous + 3
      - L3 + DiffPt1 + Streak =  (previous + 1) + 0.1 * StreakDays?
      - L3 + DiffPt2 + Streak =  (previous + 2) + 0.1 * StreakDays?
      - L3 + DiffPt3 + Streak =  (previous + 3) * 0.1 * StreakDays?

Questions
- can a habit be created without a theme? 
- MVP: streak savers
- why should I care about the points? Get app free for a month
- Optional checks

Questions for Noe
- Testing
    - how to test methods that return void? 
    - usage of private final vs private for injections in unit test
    - is there a logical/functional order for creating tests?
    - can I call a test integration if it tests only 2 parts - not end to end?
    - Am I correct to use @SpringBootTest in integration test because we need the injected bean to be managed by Spring?


- why does CreatedAt not work for putmapping?
- themeId in url (...)
- Try/Catch vs Throw

ToDo
- the default reward (L1) must be associated with all new habits - currently works and created timestamp now works! :)
- get all themes by user id - Done!
- pass a theme id when saving a habit (assumption is this be passed in the url)
- private int userId in Habit; Done
- create updateHabit (can update: theme, habitName, difficultyPoints) - Done
- add Habit counter & streakFrequency (incl changeHabitResponse, createHabitRequest, postmapping, putmapping) - Done
- add Score variable into User (incl putMapping to update score) - Simple version Done
- when habit performed, first iteration of calculate score (systemHabitUpdate() ):
    - pass habit counter, reward level habit id, habit difficulty points
    - if counter=0 and Reward=L1, calculate score
    - create putMapping for counter update (user clicks a button to say they've performed a habit) 
    - 
- Tests
    - HabitServiceTest - CreateHabit - Done
    - UserServiceTest - UpdateUserScore - Done
    - HabitControllerIntegrationTest 

### Gamification
Rewards are obtained for 1st habit completion and for streaks.  
&nbsp;  

### Reminders
User defined to match the most likely time of day for them to accomplish the habit
*Future*: ability to snooze?
&nbsp;  

### Admin
1. List all active/inactive users
2. List all habits associated with each reward level??
&nbsp; 
