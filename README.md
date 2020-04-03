# Getting starting with Android Development

In this tutorial we look at how we can create mobile apps for the android operating system. It
a very simple introduction into the world of android. 

## Installation

First things first. We need to install android studio. You can check out the link
here to show you how to get this setup. Next we can create our first project.

## Creating our Project

Once you install android studio you can being create your project.

[create_project.png]

You can view the full steps in this comment. [comment]
Once you finish create your project there are two main file you need to focus on.
These are `MainActivity.java` which is the code for your activity. The second file
is `activity_main.xml`. This contains the UI elements for you activity.


---- Comment -----

## Project Steps

* Step One - Choose the **Start a new Android Studio Project**

[create_project.png]

* Step Two - Choose your Main activity (We use the empty activity)
An activity is like a view or webpage. It shows information to the user.

[choose_main_activity.png]

* Step Three - Choose project name and package name.
The project name can be anything. The package name as shown is usually in the form
of a reverse web address. e.g **com.wftutorials.mytutorial**

[select_package_name.png]

--- end Comment

## Viewing your mobile app

You can view your mobile app using an emulator or you can connect your phone via usb and have it
displayed your phone. Emulators tends to be memory intensive but they are the best option if you 
can use your android phone. To use your android phone you need to get developer mode setup.
You can check this quick tutorial here to see how to get either of these thing setup. Lets back
to coding.

## Hello World

If you setup your project they way we showed you. You should already have the hello world going.
When we run the app with our emulator we can see the following output.

[hello_world.png]

Lets make some changes. Head to `app/src/main/java/res/layout/activity_main.xml` this the
`activity_main.xml` file. We see the content.

```html
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Lets pay attention for now to the `TextView`. In the `android:text` attribute lets update this to say
`Hello World! wftutorials`

[hello_world_changetext.png]

### Font size styling

Lets change the font size in our textview. We add the `android:textSize="20sp"` attribute to our
`TextView` tag. This is change the text size to `20sp`. (What is font size sp, dp etc)

```html
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World! wftutorials"
    android:textSize="20sp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

[hello_world_font_size.png]

### Other styling and editing options

We have other stying or editing options we can use on our text view. You can learn more about these
options via this link here.

* textStyle - Change the text style - `android:textStyle="italic"` (Bold, italic, normal)
* textAllCaps - Make text all caps - `android:textAllCaps="true"`
* visibility - Make the view invisible - `android:visibility="visible"`
* background - Change text view background - `android:background="#D81B60"`
* autolink - link urls and phone numbers etc - `android:autoLink="all"`

## Getting click events

When the user clicks on an element we want to take an action lets see how we can do this.
Update the `activity_main.xml` as show below

```html
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World! wftutorials"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:onClick="userClickedButton"
        app:layout_constraintBottom_toBottomOf="@+id/textview"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

We made some adjustments to how things appear. You can ignore this for now.
In our `Button` element we have the the `android:onClick` attribute pointing to the
`userClickedButton` function. In our `MainActivity.java` we see this function

```java
   public void userClickedButton(View view) {
        Toast.makeText(this, "User clicked button", Toast.LENGTH_LONG).show();
    }
```

Add the code above to your `MainActivity.java`. When we run this we can see the results.

[user_clicked_button.gif]


## Getting more advanced click events

What we just demonstrated was pretty simple. Lets try another to get click events from any element.

First make sure our elements in the `activity_main.xml` have ids.
The textview id is `android:id="@+id/textview"`. The button id is `android:id="@+id/button"`.

Now in the `MainActivity.java` we can get reference to these elements programatically.

```java
public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
horizontal_layout.png
}
```

At the top we initialize the `TextView` and the `Button`. Now in our `onCreate` we can do

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv = findViewById(R.id.textview);
    btn = findViewById(R.id.button);
}
```

We use `findViewById` to point to our ids we added in our `xml` file. `R` is a special reference in 
android. We can use `R.id.textview` which gives the numerical id of your xml view file.

If its confusing just remember use `findViewById` to get the reference to your element. Use `R.id.elementid`
to get the actually id for the function.

### Setting an onclick listener

Lets set a onclick listener on or `btn` element as show below.

```java
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         Toast.makeText(MainActivity.this, "User clicked button", Toast.LENGTH_LONG).show();
    }
});
```

We can now remove the `android:onClick="userClickedButton"` on our `Button` element. The 
code should work the same. This is a better way to get click events.

We can set an `OnClickListener` on our textview as well.

```java
tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "User clicked textview", Toast.LENGTH_LONG).show();
    }
});
```

So when we now click on our textview we get to see the toast.

[textview_onclick.gif]


## Getting user input

Lets see how we can get input from the user. For this we need and `EditText` view. In our 
`activity_main.xml` we add our `EditText` element.

```html
<EditText
    android:id="@+id/editText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:ems="10"
    android:inputType="textPersonName"
    android:text="Name"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"/>
```

Now we can see the results shown below.

[add_edit_text.png]

Now we need to reference our `EditText` in our code in `MainActivity.java`.

```java
EditText ed; // initialize

// in onCreate method

ed = findViewById(R.id.editText);
```

Now we have a reference to our `EditText` via `ed`. How can we get the text we run the following 
command.

```java
ed.getText().toString()
```

So wherever we call the following code we can get the current value of our edittext. Lets try this in
action. We update our `onclick` function for the button

```java
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String msg = ed.getText().toString();
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
});
```

Now when we click the button we will see the current text in our edit text view.

[getting_text_from_user.gif]

## Page navigation

Pages in android apps are called activities. You can create an activity for any new view that you
want to display to the user. Lets create a new activity.

[create_new_activity.png]

Now lets give our activity a name and click finish

[second_activity.png]

Now we have a second activity. We can navigate to this activity by using the following code.

```java
Intent intent = new Intent(MainActivity.this, SecondActivity.class);
startActivity(intent);
```

We create an intent. The intent takes the `context` so `MainActivity.this` and the name of the
class we would like to go to so `SecondActivity.class`.

The we call the `startActivity` passing in the `intent`. This will take us to the `SecondActivity`

```java
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
});
```

In our `SecondActivity` lets add some code so we can be sure we are going to the right plate.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    getSupportActionBar().setTitle("Second Activity"); // set page title
}
```

We use the `getSupportActionBar` function and call `setTitle` to set the title of your `SecondActivity.java` class.

Let see our results.

[navigate_to_activity.gif]

Now we can create as many activities we like and add different elements in them.

## Back navigation and Closing

Lets see how we can go back in activities. In this section we also learn how to close activities.
Activities open in layers. When you go to another activity the first is still open but in the background.
Its not currently active. There is also an lifecycle that you could learn more about.

In our `SecondActivity.java` lets add the following code 

```java
getSupportActionBar().setDisplayShowHomeEnabled(true);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
```

This allows use to see the backarrow.

[back_arrow.png]

To take action when the user clicks back lets add the code

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if(id == android.R.id.home){
        finish();
    }
    return super.onOptionsItemSelected(item);
}
```

So if the `id` is equal to `android.R.id.home` we call the `finish()` function. This closes the activity.
Any activity you are on if you call this function it will close the activity.


## Working with layouts

Layouts is how we structure our UI elements in our activities. We are going to look at three main views to 
get you started. They are

* LinearLayout - as the name implements its linear either vertical or horizontal
* RelativeLayout - each element can be relative to other elements
* ScrollView - This is a scroll element. So you can create views that scroll.

## Working with the Linear Layout

We can create a `LinearLayout` added the code below. Notice in `LinearLayout` we added the
`android:orientation="vertical"`. So every element is automatically placed beneath the last element.

```html
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text=""/>

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World! wftutorials"
        android:textSize="20sp" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button" />

</LinearLayout>
```

[linear_layout_example.png]

Lets add a `LinearLayout` with orientation horizontal. Lets see how that looks. Add the code below.
We can add this within our `LinearLayout` underneath our primary button.

```html
<LinearLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button 1" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button 2" />


    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button 3" />
</LinearLayout>
```

[horizontal_layout.png]

So using the `android:orientation` horizontal option elements are aligned next to each other. With layouts
we can add backgrounds, ids and onclick listeners just like we did with the textview and button.

## Working with the Relative Layout

Lets create a `RelativeLayout`. Add the code below

```html
<RelativeLayout
android:layout_width="wrap_content"
android:layout_height="wrap_content">

<TextView
    android:id="@+id/clickme"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Click me"/>

<Button
    android:layout_toRightOf="@+id/clickme"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Take Action" />

</RelativeLayout>
```

[relative_layout.png]

Notice in our button we added the `android:layout_toRightof` attribute. Using this attribute
we are saying the button should be placed to the right of the TextView with the id of `clickme`

You can use a lot more of these attributes some are listed below.

* android:layout_above
* android:layout_below
* android:layout_toLeftOf
* android:layout_alignParentBottom
* android:layout_centerHorizontal

All the options shown above can affect how we can manipulate elements within a RelativeLayout.
This really gives us a lot of options. For e.g. in the `wfTutorials` mobile app the cards we
create to list the tutorials were created using RelativeLayout. (put example here)

## Working with the ScrollView

Lets try working with scrollview. This is great when you layout extends beyond the primary view
of the phone. This almost always happens and so you always need an ScrollView (or other views that scroll)
So Lets try it out in the `SecondActivity`. In the `activity_second.xml` lets add the content below

```html
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ScrollView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="20sp"
                android:text="@string/my_content">
            </TextView>

        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

So we have a `ScrollView`. Inside the `ScrollView` we need to add a `LinearLayout`. ScrollViews
need to have a primary layout. Then we can structure anything else inside it.

Now in the `LinearLayout` we add a `TextView`. The TextView has the attribute `android:text` which points to
our `values/strings.xml` file.

[string_my_content.png]

In the `strings.xml` we can add strings and point to them either in code or in our xml files.
In try this out in the `my_content` element make sure to add alot of text as shown in the picture above.
So we can test the scrollview correctly.

Lets see the results.

[scroll_views_example.gif]

## Working with images

There are many ways we can work with images. One of the simplest ways is using and imageview. 
Lets add a imageview. In our `activity_main.xml` lets add the code

```html
<ImageView
    android:layout_width="165dp"
    android:layout_height="165dp"
    android:src="@drawable/cover"/>
```

Using `android:src` we assign to an image called `cover.png`.

[cover_location.png]

We can set the element width and height using `android:layout_width` and `android:layout_height`.

[image_view_sample.png]

We can assign the `src` of a image view programatically. Lets see how.

```java
ImageView iv;

// in onCreate

iv = findViewById(R.id.imageView); // dont forget to give your image view element an id

iv.setImageDrawable(getResources().getDrawable(R.drawable.cover)); // set the image
```

Let me example the last line.

The function to call on our imageview to set our drawable is `setImageDrawable` however
this takes and id. So we need to get the Id of our stored image.

To do this we use `getResources.getDrawable` function and pass in the reference being
`R.drawable.cover`.

In the example below. We assigned a onclick listener to the second button (button 1) and when we load
our application we click button one to see the image.

[display_image_dynamically.gif]

See if you can get your application to work like this.

### Adding image to a textview

We can place an image on a textview. Let see how.

Just add the following attribute

```java
android:drawableLeft="@drawable/ic_save"
```

And the above to the textview. `ic_save` is a drawable we added to the drawable folder.

[drawable_left_textview.png] 


## ActionBar menus

Lets create actionbar menus. These are the little icons in the actionbar or the extra options via
the overflow menu. In our `main/res` folder we create a menu folder

[menu_folder.png]

So lets add a menu resource file. We name it `main.xml`

[creating_actionbar_menu.png]

Lets add this content to the `main.xml`

```html
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/action_one"
        android:orderInCategory="99"
        android:title="One"
        app:showAsAction="never" />
    
</menu>
```

So in the `menu` element. We have enclosed an `item`. The `item` consists of an id, title and `orderInCategory`
options. Finally we have `app:showAsAction="never"` which says whether or not the item should be shown.

Now in our `MainActivity.java` lets load this menu. Add the code below.

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}
```

The results is shown below.

Before we see the overflow menu showing

[before_overflow_menu.png]

When we click on it we see the options

[after_overflow_clicked.png]

We can add more `items`

```html
<item
    android:id="@+id/action_one"
    android:orderInCategory="99"
    android:title="One"
    app:showAsAction="never" />

<item
    android:id="@+id/action_two"
    android:orderInCategory="99"
    android:title="Two"
    app:showAsAction="never" />

<item
    android:id="@+id/action_three"
    android:orderInCategory="99"
    android:title="Three"
    app:showAsAction="never" />
```

[more_options.png]

### Showing icons in your actionbar

To add icons to your action bar menus we just need to add the `android:icon` attribute.
This is shown below

```html
<item
    android:id="@+id/action_battery"
    android:orderInCategory="99"
    android:title="Battery"
    android:icon="@drawable/ic_battery_30_white_24dp"
    app:showAsAction="always" />
```

We however have to provide a drawable with our icon attribute. In android studio you can do this via
vector assets.

[creating_vector_assets.png]

Once we create the icon we can add it to our item.

[creating_vector_asset.png]

Also note our `app:showAsAction` is shown as always. This means we always want the icon to show.
Now let see how this look.

[showing_action_bar.png]

### Responding to action menus clicks

To respond to action menu click events we use the `onOptionsItemSelected` function. 
We override this function and implement the code we need to use.

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if( id == R.id.action_one){
        Toast.makeText(MainActivity.this,"Clicked action one", Toast.LENGTH_LONG).show();
    }
    return super.onOptionsItemSelected(item);
}
```

[action_menu_clicked.gif]

## Creating Dialogs

Dialogs are a great way to display content or provide different options to the user.
Lets see how we can create a popup dialog in andorid.

First we create a function called `showDialog` this is where we will place the code
for our dialog. Add the code below

```java
public void showDialog(){
    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
    alertDialog.setTitle("Hello World Dialog");
    alertDialog.setMessage("This is an alert Dialog");
       alertDialog.show();
}
```

Within `showDialog` we create an `AlertDialog` object. It takes a context and we call the
`create` function.

Then we set a title and a message. In order to show the dialog we call the
`show` function. The results is shown below.

[show_simple_dialog.png]

We just create a simple dialog. We can display this dialog by calling `showDialog()`.

### Adding buttons

Lets add some buttons to your dialog. One button will say ok. The other will say cancel.
We do this by calling the `setButton` function

```java
alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Ok pressed", Toast.LENGTH_LONG).show();
        }
    });
```

The `setButton` function takes the type of button, the text and a OnclickListener. When this button
is pressed we render a `TOAST`.

The full code for the both buttons is shown below. 
We call `setButton` twice and we add positive and negative buttons.

```java
    public void showDialog(){
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Hello World Dialog");
        alertDialog.setMessage("This is an alert Dialog");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Ok pressed", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }
```

The results is shown below.

[simple_dialog_with_buttons.png]

### Layouts in dialogs

Lets add a layout to the dialog. This allows us to have more complex views in our dialogs.
In the layout folder lets create a new layout called `dialog_layout`.

We use the builder to create the layout. Just for fun using the design view. For beginners I would
stick with the text view.

[design_view.png]

Once our view is complete. Lets add it to our dialog. We use the `LayoutInflater` class and create
our view by using the `inflater` object and providing the id via `R.layout.dialog_layout`.

```java
LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View view =inflater.inflate(R.layout.dialog_layout,null);
```

The above works. Dont think to much about it. You might have to change `MainActivity` if your class
is named different. This is the content. If you know enough of java you realize we are doing some casting.

ANYWAY!!!!

Once we have a view we can call the `setView` function on our `alertDialog` object.

```java
alertDialog.setView(view);
```

Thats it. You can view the full function code here -->

--comment--
# Creating a dialog with a custom layout

```java
public void showDialog(){
    LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view =inflater.inflate(R.layout.dialog_layout,null);
    final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
    alertDialog.setTitle("Hello World Dialog");
    alertDialog.setView(view);
    //alertDialog.setMessage("This is an alert Dialog");
    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Ok pressed", Toast.LENGTH_LONG).show();
        }
    });
    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    });
    alertDialog.show();
}
```


--end comment--

You can view how it looks via the picture below.

[dialog_custom_layout.png]

### Getting click events in custom layouts

Lets see how we can add a button in our custom layout and get a click event.
First we add a button to our custom layout. So our layout now looks like

[dialog_custom_layout_with_button.png]

We also remove the `setButton` calls. So we have no default buttons in our layout.
Now lets get a click event. Remeber our `view` we created from the inflater we use that
to find our button by id

```java
View view =inflater.inflate(R.layout.dialog_layout,null);
Button btn = view.findViewById(R.id.button2);
```

Once that is done we can set out onclick listener as normal.

```java
btn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"Button clicked", Toast.LENGTH_LONG).show();
    }
});
```

Thats it. We can no add buttons and react to events in our dialog. 

The full code is here ->

-- comment --

# Custom dialog with click events

```java
public void showDialog(){
    LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view =inflater.inflate(R.layout.dialog_layout,null);
    Button btn = view.findViewById(R.id.button2);
    btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Button clicked", Toast.LENGTH_LONG).show();
        }
    });
    final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
    alertDialog.setTitle("Hello World Dialog");
    alertDialog.setView(view);
    //alertDialog.setMessage("This is an alert Dialog");
    alertDialog.show();
}
```
-- end comment --

You can see the results here.

[dialog_on_click_event.gif]