package com.nanda.stickyheaderrecyclerview.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nanda.stickyheaderrecyclerview.R;
import com.nanda.stickyheaderrecyclerview.model.StickyHeader;
import com.nanda.stickyheaderrecyclerview.model.StickyItem;
import java.util.ArrayList;
import java.util.List;
import org.zakariya.stickyheaders.SectioningAdapter;

/**
 * Created by nandagopal on 1/7/17.
 */
public class StickyHeaderAdapter extends SectioningAdapter {

  private Context context;
  private LayoutInflater inflater;
  private List<StickyHeader> stickyHeaderList;

  public StickyHeaderAdapter(Context context) {
    this.context = context;
    stickyHeaderList = new ArrayList<>();
    inflater = LayoutInflater.from(context);
  }

  public void setStickyItemList(List<StickyHeader> itemList) {
    if (itemList == null) {
      return;
    }
    stickyHeaderList.clear();
    stickyHeaderList.addAll(itemList);
    notifyAllSectionsDataSetChanged();
  }

  @Override public boolean doesSectionHaveHeader(int sectionIndex) {
    return !TextUtils.isEmpty(stickyHeaderList.get(sectionIndex).getHeader());
  }

  @Override public boolean doesSectionHaveFooter(int sectionIndex) {
    return false;
  }

  @Override public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerUserType) {
    View view = inflater.inflate(R.layout.item_header, parent, false);
    return new ItemHeaderViewHolder(view);
  }

  @Override public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemUserType) {
    View view = inflater.inflate(R.layout.item_child, parent, false);
    return new ItemChildViewHolder(view);
  }

  @Override public int getNumberOfSections() {
    return stickyHeaderList.size();
  }

  @Override public int getNumberOfItemsInSection(int sectionIndex) {
    return stickyHeaderList.get(sectionIndex).getStickyItemList().size();
  }

  @Override public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int sectionIndex,
      int headerUserType) {
    super.onBindHeaderViewHolder(viewHolder, sectionIndex, headerUserType);

    ItemHeaderViewHolder holder = (ItemHeaderViewHolder) viewHolder;

    StickyHeader stickyHeader = stickyHeaderList.get(sectionIndex);

    holder.setHeaderDataToView(stickyHeader);
  }

  @Override
  public void onBindItemViewHolder(ItemViewHolder viewHolder, int sectionIndex, int itemIndex,
      int itemUserType) {
    super.onBindItemViewHolder(viewHolder, sectionIndex, itemIndex, itemUserType);

    ItemChildViewHolder holder = (ItemChildViewHolder) viewHolder;

    StickyItem stickyItem = stickyHeaderList.get(sectionIndex).getStickyItemList().get(itemIndex);

    holder.setChildDataToView(stickyItem);
  }

  class ItemHeaderViewHolder extends HeaderViewHolder {

    @BindView(R.id.tv_header) TextView tvHeader;

    public ItemHeaderViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void setHeaderDataToView(StickyHeader item) {
      tvHeader.setText(item.getHeader());
    }
  }

  class ItemChildViewHolder extends SectioningAdapter.ItemViewHolder {

    @BindView(R.id.tv_child) TextView tvCild;

    public ItemChildViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void setChildDataToView(StickyItem item) {
      tvCild.setText(item.getChild());
    }
  }
}
