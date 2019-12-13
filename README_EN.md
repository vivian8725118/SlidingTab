# SlidingTab
SlidingTab which can cross tab and word,and you can set a gradient color for the whole tab widget.

[中文版README](https://github.com/vivian8725118/SlidingTab/blob/master/README.md)

# Feature

## 1.Support cross tab and word
![](https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab4.png)

## 2.Support linear gradient color
<div>
<image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab8.png" width=30% height=30%/>
        <image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab7.png" width=30% height=30%/>
        <image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab6.png" width=30% height=30%/>
</div>

## 3.Support color settings
<div>
<image hspace="20" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab3.png" width=40% height=40%/>
</div>

# Usage
## 1. Import package 

```groovy
implementation 'com.vivian.widgets:slidingtab:1.0.2'

```

## 2. Write in xml files

```xml
<com.vivian.slidingtab.SlidingTab
        android:id="@+id/sliding_tab"
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        app:strokeWidth="2dp"
        app:mainColor="#1A51AD"
        app:mainColorRes="@color/colorAccent"
        app:radius="100dp"
        app:tabHeight="100dp"
        app:textSize="16sp"
        app:startColor="#a1aa0b"
        app:endColor="#1F8F70"
        android:layout_gravity="center"
        android:layout_height="wrap_content"/>
  ```

        app:strokeWidth="2dp"   //set the width of outside roundrect
        app:mainColor="#1A51AD"  //set main color of the whole tab
        app:mainColorRes="@color/colorAccent"  //set main color resource.If both "mainColor" and "mainColorRes" are set,it will show as "mainColorRes“
        app:radius="100dp"  //set roundcorner radius size
        app:tabHeight="100dp" //set the height of tab
        app:textSize="16sp"  //set textsize
        app:startColor="#a1aa0b"  //set start color of gradient part
        app:endColor="#1F8F70"   //set end color of gradient part

## 3、 Write in Java code

### 3.1 Set titles

```java        
slidingTab.setTitles("Course", "Document");
```
or

```java
slidingTab.setTitles(List<String> titles) 
```

### 3.2 Bind ViewPager.onPageChangeListener

```java
slidingTab.bindViewPager(viewPager);
```

### 3.3 setOnTabClickListener

```java
 slidingTab.setOnTabClickListener(new SlidingTab.OnTabClickListener() {
            @Override
            public void onTabClick(int position) {
                viewPager.setCurrentItem(position);
            }
  });
```

# License

    Copyright 2019 Vivian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


