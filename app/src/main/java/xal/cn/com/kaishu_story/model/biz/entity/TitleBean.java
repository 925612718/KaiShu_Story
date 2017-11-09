package xal.cn.com.kaishu_story.model.biz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 * 作者:刘鑫
 */

public class TitleBean {

    /**
     * errcode : 0
     * result : {"list":[{"title":"最新","contenttype":"nav_lateststory","contentid":100002,"iconurl":"https://cdn.kaishuhezi.com/kstory/banduimg/image/324a95c0-6090-4280-b327-899d6028093f.png","link":"","tagtype":1},{"title":"叫早","contenttype":"nav_tag","contentid":40820,"iconurl":"https://cdn.kaishuhezi.com/kstory/banduimg/image/97a515b5-adb6-4cc8-9c0c-efbb9748351e.png","link":"","tagtype":1},{"title":"哄睡","contenttype":"nav_tag","contentid":40815,"iconurl":"https://cdn.kaishuhezi.com/kstory/banduimg/image/8d8a6a5e-7ec7-4965-b273-2f8e26a64aa2.png","link":"","tagtype":1},{"title":"3岁+","contenttype":"nav_tag","contentid":40703,"iconurl":"https://cdn.kaishuhezi.com/kstory/banduimg/image/5f32149b-db2a-46d5-9ad7-aac336eeeb26.png","link":"","tagtype":1},{"title":"分类","contenttype":"nav_assortment","contentid":0,"iconurl":"https://cdn.kaishuhezi.com/kstory/banduimg/image/c2ba864d-f0c8-4f54-84df-9509dab23c07.png","link":"","tagtype":1}]}
     */

    private int errcode;
    private ResultBean result;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 最新
             * contenttype : nav_lateststory
             * contentid : 100002
             * iconurl : https://cdn.kaishuhezi.com/kstory/banduimg/image/324a95c0-6090-4280-b327-899d6028093f.png
             * link :
             * tagtype : 1
             */

            private String title;
            private String contenttype;
            private int contentid;
            private String iconurl;
            private String link;
            private int tagtype;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContenttype() {
                return contenttype;
            }

            public void setContenttype(String contenttype) {
                this.contenttype = contenttype;
            }

            public int getContentid() {
                return contentid;
            }

            public void setContentid(int contentid) {
                this.contentid = contentid;
            }

            public String getIconurl() {
                return iconurl;
            }

            public void setIconurl(String iconurl) {
                this.iconurl = iconurl;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public int getTagtype() {
                return tagtype;
            }

            public void setTagtype(int tagtype) {
                this.tagtype = tagtype;
            }
        }
    }
}
