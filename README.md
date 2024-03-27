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
- enters a habit name (open entry)
- adds a theme to it
    - if the theme does not exist, they can add/create a new one
    - if the theme already exists, they will be able to select it from a drop down (UI)
    - means that when user clicks drop down, there will be a call to BE to retrieve all themes for that user
    - what is a theme? an overarching goal 
- that a number of habits relate to, e.g. health or career

Questions
- can a habit be created without a theme? 

ToDo
- the default reward (L1) must be associated with all new habits - currently works and created timestamp now works! :)
- get all themes by user id - Done!
- pass a theme id when saving a habit (assumption is this be passed in the url)
- private int userId in Habit; Done

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
