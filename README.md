# SlidingTab
可以交叉tab和文字的SlidingTab
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

## 1、 在xml中设置
```
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
        app:mainColorRes="@color/colorAccent"  //设置主色资源
        app:radius="100dp"  //设置圆角尺寸
        app:tabHeight="100dp" //设置tab高度
        app:textSize="16sp"  //设置字体大小
        app:startColor="#a1aa0b"  //设置渐变色起始颜色
        app:endColor="#1F8F70"   //设置渐变色结束颜色

## 2、 在java中设置

### 2.1 设置titles
```        
slidingTab.setTitles("课程", "文档");
```
或者
```
slidingTab.setTitles(List<String> titles) 
```

### 2.2 绑定ViewPager的onPageChangeListener

```
 viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               //设置滚动位移
                slidingTab.setScrollFromCurrentPosition(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
            //设置当前position
                slidingTab.setCurrentPostion(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
```
