# viewpager
&lt;Android> ViewPager


## Provide
Use like RecyclerView

Create holder
```java
class THolder extends VpHolder<String> {

    TextView textView;

    public THolder(LayoutInflater inflater, ViewGroup container) {
        super(inflater, container, R.layout.item);
    }

    @Override
    protected void initView(View itemView) {
        textView = getView().findViewById(R.id.textView);
    }

    @Override
    protected void onBindData(String data) {
        textView.setText(data);
        textView.setBackgroundColor(Color.CYAN);
    }

}
```

Create adapter
```
public class TAdapter extends VpAdapter<String> {
    @Override
    protected VpHolder<String> onCreateHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return new THolder(inflater, container);
    }
}
```

In your activity or fragment
```
viewPager = findViewById(R.id.viewPager);
tAdapter = new TAdapter();
tAdapter.setData(data);
viewPager.setAdapter(tAdapter);
```
Don't worry about data notifyDataSetChanged invalid ,when you want to update data, just call setData(),

## Banner
In your xml:
```
<com.busycount.viewpager.banner.Banner
    android:id="@+id/viewPager"
    android:layout_width="0dp"
    android:layout_height="200dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

Define your adapter:
```
public class BannerAdapter extends BaseBannerAdapter<String> {

    public BannerAdapter(FragmentManager fm, @NonNull List<String> list) {
        super(fm, list);
    }

    @Override
    public Fragment getItem(int position, String data) {
        // Your fragment
        return BannerFragment.newInstance(data);
    }
}
```

at last,just call
```
banner.setBannerAdapter(bannerAdapter);
```

## Implementation
Step 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.busycount:viewpager:0.2'
}
```