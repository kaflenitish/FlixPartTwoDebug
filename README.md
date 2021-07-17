# FlixsterPartTwoDebuggingChallange

## RESULT

Fixed six problems

1. RelativeLayout was assigned with ConstraintLayout in MovieAdapter.
2. getItemCount returned 0 instead of movies.size()
3. movie.getMovieId() in asyncHttpClient.get instead of hard coded value.
4. initializeYoutube —> youtubeKey value instead of hard coded value.
5. MovieAdapter —> intent clickListener to DetailActivity instead of MainActivity (the intent was set to default page)
6. activity_detail.xml YouTube width set to match_parent instead of 0dp (fixed youtube design view)


## Debugging strategies 

### Basic debugging workflow
* Understand how to reproduce the issue 
  * Retrace steps, focus on the input or sequence of inputs that caused the issue (toasts)
* Figure out the most likely reasons the problem occurred 
  * Think about the tasks that would be happening as the app crashes and which ones you suspect might be causing this kind of crash
* Review each suspect and narrow down until you have a culprit
  * Use logcat/toasts/debugger to track down the exact cause of the issue
* Brainstorm potential solutions 
  * Think about what you can change to fix this issue
* Resolve the issue 
  * Implement the changes and test the app

### 3 Main ways to debug
* **Toasts : small in app notifications**
* **Logging with logcat : sending data to the log ( viewable from logcat)**
* **Debugger witgh Breakpoints : Set a breakpoint so you can pause app execution and look at variable states at specific points**


### **Toasts : best as a preventative**
#### Good
* Very fast to set up
* Easy to see while using app normally
#### Bad
* Can not stack, some may not show if multiple try to play at the same time
* They can not be copied from and do not persist
#### Best times to use
* Checking if things that fail gracefully (no crash/error ) are working during normal use 
* Examples Listeners, and Asynchronous callbacks


### **Logging : with Logcat**
#### Good
* Easy to check multiple things at the same time
* Can be reviewed after crash
* Most crashes will show up in logcat with a Line #
* Can filter based on options
#### Bad
* It can be hard to use while using the app, so you may be forced to review after crash or after run.
#### Best times to use
* First place to check if you get an unexpected crash
* If you are unsure if an API call is working you can print the response URL and check in browser.
* If you are looking for the cause of a crash that is coming form a code you have not written (example glide or room)


### **Breakpoints : with the Debugger**
#### Good
* Gives you the absolute most information about the state of variables.
* Requires no extra lines of code
* Allows for line by line code execution 

#### Bad
* Line by line code exploration can take a lot of time
* Can make Async functions (API calls) break 

#### Best times to use
* When you know the issue is related to a variable assigned an unexpected value (null, or junk), but you are unsure where 
* When you are unable to find the cause via Logging



# Hints 
* Have you checked log cat?
* Which layout should we be using? Constraint or Relative 🔍
* How big is the list of movies we're returning?
* How do we launch an activity?
* Have you Taken a look at the XML file?
* Take a look at the Movie model...
