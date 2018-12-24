# viewpager
&lt;Android> ViewPager


## Provide
Use like RecyclerView

Create holder
```java
class THolder extends VpHolder<String> {

    TextView textView;

    public THolder(LayoutInflater inflater, ViewGroup container) {
        super(inflater, container);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.item;
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
tAdapter.attachViewPager(viewPager);
```
Don't worry about data notifyDataSetChanged invalid ,when you want to update data, just call setData(),


## Implementation
Step 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:
```xml
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```xml
dependencies {
    implementation 'com.github.busycount:viewpager:0.1'
}
```