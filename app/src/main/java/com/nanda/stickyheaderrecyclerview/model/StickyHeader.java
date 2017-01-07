package com.nanda.stickyheaderrecyclerview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandagopal on 1/7/17.
 */
public class StickyHeader {

  public String header;
  public List<StickyItem> stickyItemList=new ArrayList<>();

  public StickyHeader(String header, List<StickyItem> stickyItemList) {
    this.header = header;
    this.stickyItemList = stickyItemList;
  }

  public StickyHeader() {
  }

  public List<StickyItem> getStickyItemList() {
    return stickyItemList;
  }

  public void setStickyItemList(List<StickyItem> stickyItemList) {
    this.stickyItemList = stickyItemList;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }
}
