package com.camnter.easytest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.camnter.easyslidingtabs.widget.EasySlidingTabs;
import com.camnter.easytest.adapter.TabsFragmentAdapter;
import com.camnter.easytest.fragment.FirstFragment;
import com.camnter.easytest.fragment.FourthFragment;
import com.camnter.easytest.fragment.SecondFragment;
import com.camnter.easytest.fragment.ThirdFragment;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EasySlidingTabs easySlidingTabs;
    private ViewPager easyVP;
    private TabsFragmentAdapter adapter;
    List<Fragment> fragments;

    public static final String[] titles = {"Any", "Bay", "Cue", "Dam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViews();
        this.initData();
    }

    private void initViews(){
        this.easySlidingTabs = (EasySlidingTabs) this.findViewById(R.id.easy_sliding_tabs);
        this.easyVP = (ViewPager) this.findViewById(R.id.easy_vp);
    }

    private void initData() {
        this.fragments = new LinkedList<>();
        FirstFragment first = FirstFragment.getInstance();
        SecondFragment second = SecondFragment.getInstance();
        ThirdFragment third = ThirdFragment.getInstance();
        FourthFragment fourth = FourthFragment.getInstance();
        this.fragments.add(first);
        this.fragments.add(second);
        this.fragments.add(third);
        this.fragments.add(fourth);

        this.adapter = new TabsFragmentAdapter(this.getSupportFragmentManager(), titles, this.fragments);
        this.easyVP.setAdapter(this.adapter);
        this.easySlidingTabs.setViewPager(this.easyVP);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
