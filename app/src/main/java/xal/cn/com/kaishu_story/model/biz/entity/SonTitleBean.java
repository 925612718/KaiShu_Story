package xal.cn.com.kaishu_story.model.biz.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 * 作者:刘鑫
 */

public class SonTitleBean {

    /**
     * errcode : 0
     * result : {"list":[{"title":"健康","contenttype":"nav_tag","contentid":40873,"iconurl":"https://cdn.kaishuhezi.com/kstory/microcourse/image/b65c392f-d987-4285-a313-311973908918.png","link":"","tagtype":2},{"title":"启蒙","contenttype":"nav_tag","contentid":40872,"iconurl":"https://cdn.kaishuhezi.com/kstory/microcourse/image/2e84a67b-5cf9-4f7b-98d2-a39ec9d44535.png","link":"","tagtype":2},{"title":"妈妈成长","contenttype":"nav_tag","contentid":40874,"iconurl":"https://cdn.kaishuhezi.com/kstory/microcourse/image/7fb2b91f-0f09-4614-89c8-e92740ce3d9b.png","link":"","tagtype":2},{"title":"家庭教育","contenttype":"nav_tag","contentid":40871,"iconurl":"https://cdn.kaishuhezi.com/kstory/microcourse/image/0275e56b-cac5-42e5-b75d-5cb4f987f3e0.png","link":"","tagtype":2},{"title":"全部","contenttype":"nav_tag","contentid":40875,"iconurl":"https://cdn.kaishuhezi.com/kstory/microcourse/image/be87bbea-cef0-4d91-acce-3c76adddebb3.png","link":"","tagtype":2}]}
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
             * title : 健康
             * contenttype : nav_tag
             * contentid : 40873
             * iconurl : https://cdn.kaishuhezi.com/kstory/microcourse/image/b65c392f-d987-4285-a313-311973908918.png
             * link :
             * tagtype : 2
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
