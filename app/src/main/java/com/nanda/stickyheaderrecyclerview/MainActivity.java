package com.nanda.stickyheaderrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nanda.stickyheaderrecyclerview.adapter.StickyHeaderAdapter;
import com.nanda.stickyheaderrecyclerview.model.StickyHeader;
import com.nanda.stickyheaderrecyclerview.model.StickyItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;

  private StickyHeaderAdapter adapter;
  private List<StickyHeader> headerList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    adapter = new StickyHeaderAdapter(this);
    recyclerView.setAdapter(adapter);

    setData();
    adapter.setStickyItemList(headerList);
  }

  private void setData() {
    headerList = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      List<StickyItem> stickyItemList = new ArrayList<>();
      Random random = new Random();
      for (int j = 0; j < random.nextInt(20); j++) {
        stickyItemList.add(new StickyItem("Child Item - " + j));
      }
      headerList.add(new StickyHeader("Header Item - " + i, stickyItemList));
    }
  }
}
