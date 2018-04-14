# VG-Constuct [PROJECT]
## Getting Started(#getting-started)
## Reference[#reference]
# Getting Started
>> - [ ] [Setting up new Project](#setting-up-new-project)
>>> - [x] [Custom font](#custom-font)
>>> - [x] [Custom theme](#custom-theme)


>> - [ ] [Setting up new Project](#setting-up-new-project)


# Setting up new Project
Command line: 

    - [GUI] URL_Bar/Material Design Color Palette/.. +> Custom Theme Editor
    - [GUI] ../servicelawrence => ../servicelawrence.view(such as custom,...)
    
# Reference
> - [ ](Build Theme Structure)(#build-theme-structure)

# Build Theme Structure)
> - **Using attribute *android:theme="@style/YourTheme"* in Android project**
>> - Structure 1:
>>> - **Application** *android:theme="@style/AppTheme.NoActionBar"*
>>>> - **SplashActivity** *android:theme="@style/SplashTheme"* => ApplicationCompat (No BaseActivity)
>>>> - **LoginActivity** *android:theme="@style/FontTheme"* => ChildTheme extends NoActionBar
>>>> - Similarity with other theme
>>> - How about **Toolbar**. We will custom in layout for each screen or each activity.

>> - Structure 2:
>>> - **Application** *android:theme="@style/AppTheme.NoActionBar*
>>>> - **SplashActivity** *android:theme="@style/SplashTheme"* => New Theme extends NoActioBar
>>>> - **LoginActivity** *Just inherited from Application*

>> - Summarize:
>>> - Encourage using some avaible theme:

        <style name="AppTheme.NoActionBar" parent="Theme.AppCompat.Light.NoActionBar">
            <item name="android:typeface">monospace</item>
            <item name="windowActionBar">false</item>
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
            <item name="android:actionMenuTextColor">@color/white</item>
            <item name="android:windowBackground">@color/white</item>
        </style>
        
        <style name="SplashTheme" parent="Theme.AppCompat.Light.NoActionBar">
            <item name="colorPrimary">@android:color/white</item>
            <item name="colorPrimaryDark">@android:color/white</item>
            <item name="colorAccent">@android:color/white</item>
            <item name="android:windowBackground">@drawable/background_splash_screen</item>
        </style>
        
        <?xml version="1.0" encoding="utf-8"?>
        <layer-list xmlns:android="http://schemas.android.com/apk/res/android">
            <item android:drawable="@color/white" />
            <item>
                <bitmap
                    android:gravity="center"
                    android:src="@drawable/ic_splash_launcher" />
            </item>
        </layer-list>
        
        <style name="AppTheme.NoActionBar" parent="Theme.AppCompat.Light.NoActionBar">
            <item name="windowActionBar">false</item>
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimary</item>
            <item name="colorAccent">@color/colorAccent</item>
            <item name="android:splitMotionEvents">false</item>
            <item name="android:windowEnableSplitTouch">false</item>
        </style>

        <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
            <item name="android:windowBackground">@drawable/splash_bg</item>
        </style>

        <style name="AppTheme.FullScreen" parent="Theme.AppCompat.Light.NoActionBar">
            <item name="windowActionBar">false</item>
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
            <item name="android:windowIsTranslucent">true</item>
            <item name="android:windowBackground">@android:color/transparent</item>
            <item name="android:windowAnimationStyle">@null</item>
        </style>
        

