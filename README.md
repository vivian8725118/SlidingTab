# SlidingTab
可以交叉tab和文字的SlidingTab，支持设置渐变色。

[ENGLISH_VERSION_README](https://github.com/vivian8725118/SlidingTab/blob/master/README_EN.md)

# 功能

## 1.支持底色交叉文字
![](https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab4.png)

## 2.支持渐变色
<div>
<image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab8.png" width=30% height=30%/>
        <image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab7.png" width=30% height=30%/>
        <image hspace="2" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab6.png" width=30% height=30%/>
</div>

## 3.支持颜色修改
<div>
<image hspace="20" src="https://github.com/vivian8725118/SlidingTab/blob/master/app/art/slidingtab3.png" width=40% height=40%/>
</div>

# 使用
## 1、导入包

```groovy
implementation 'com.vivian.widgets:slidingtab:1.0.2'

```

## 2、 在xml中设置
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
  
        app:strokeWidth="2dp"   //设置外围线框宽度
        app:mainColor="#1A51AD"  //设置主色
        app:mainColorRes="@color/colorAccent"  //设置主色资源。如果mainColor和mainColorRes同时设置了，按mainColorRes内容显示
        app:radius="100dp"  //设置圆角尺寸
        app:tabHeight="100dp" //设置tab高度
        app:textSize="16sp"  //设置字体大小
        app:startColor="#a1aa0b"  //设置渐变色起始颜色
        app:endColor="#1F8F70"   //设置渐变色结束颜色


## 3、 在java中设置

### 3.1 设置titles
```java       
slidingTab.setTitles("课程", "文档");
```
或者
```java
slidingTab.setTitles(List<String> titles) 
```

### 3.2 绑定ViewPager的onPageChangeListener

```java
slidingTab.bindViewPager(viewPager);
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


