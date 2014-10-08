package com.liusoft.baseWeb.client.constant;

/**
 * 系统常用常量
 *
 * @author liukunyang
 * @version V1.0
 * @date 2013-10-11 下午06:22:35
 */
public class CacheKeyConstant {


    /**
     * 商品评论标签缓存key
     */
    private static final String PRODUCT_COMMENT_TAG = "product_comment_tag_";


    /**
     * 商品缓存key
     */
    private static final String PRODUCT = "product_";


    /**
     * 商品评论缓存key
     * 好评
     */
    private static final String PRODUCT_POSITIVE_COMMENT = "product_positive_comment";

    /**
     * 商品评论缓存key
     * 中评
     */
    private static final String PRODUCT_MODERATE_COMMENT = "product_moderate_comment";

    /**
     * 商品评论缓存key
     * 差评
     */
    private static final String PRODUCT_NEGATIVE_COMMENT = "product_negative_comment";


    /**
     * 商品包装清单缓存key
     */
    private static final String PRODUCT_PACKAGE_LIST = "product_package_list";


    /**
     * 商品售后缓存key
     */
    private static final String PRODUCT_AFTER_SALE_SERVICE = "product_after_sale_service";


    /**
     * 缓存时间1天*
     */
    public static final Integer CAHCE_EXP_ONE_DAY = 60 * 60 * 24 * 1;


    public static String getProductCommentTag(long skuId) {
        return PRODUCT_COMMENT_TAG + skuId;
    }


    public static Integer getProductCommentTagExpire() {
        return CAHCE_EXP_ONE_DAY;
    }


    public static String getPositiveComment(long skuId) {
        return PRODUCT_POSITIVE_COMMENT + skuId;
    }

    public static Integer getPositiveCommentExpire() {
        return CAHCE_EXP_ONE_DAY;
    }

    public static String getModerateComment(long skuId) {
        return PRODUCT_MODERATE_COMMENT + skuId;
    }

    public static Integer getModerateCommentExpire() {
        return CAHCE_EXP_ONE_DAY;
    }


    public static String getNegativeComment(long skuId) {
        return PRODUCT_NEGATIVE_COMMENT + skuId;
    }


    public static Integer getNegativeCommentExpire() {
        return CAHCE_EXP_ONE_DAY;
    }


    public static String getPackageList(long skuId) {
        return PRODUCT_PACKAGE_LIST + skuId;
    }

    public static Integer getPackageListExpire() {
        return CAHCE_EXP_ONE_DAY;
    }


    public static String getProduct(long skuId) {
        return PRODUCT + skuId;
    }

    public static Integer getProductExpire() {
        return CAHCE_EXP_ONE_DAY;
    }

    public static String getProductAfterSaleService(long skuId) {
        return PRODUCT_AFTER_SALE_SERVICE;  //To change body of created methods use File | Settings | File Templates.
    }


    public static Integer getProductAfterSaleServiceExpire() {
        return CAHCE_EXP_ONE_DAY;
    }
}
