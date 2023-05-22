package models;

public class ResultOpenCategories {
    private Integer success, appids, match_count, solr_index;
    private String store_item_keys;
    private boolean possible_has_more;

    public Integer getSuccess() {
        return success;
    }

    public Integer getAppids() {
        return appids;
    }

    public Integer getMatch_count() {
        return match_count;
    }

    public Integer getSolr_index() {
        return solr_index;
    }

    public String getStore_item_keys() {
        return store_item_keys;
    }

    public boolean isPossible_has_more() {
        return possible_has_more;
    }

}
