package com.example.k2ohashi.testapp.Databese;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by k2ohashi on 17/05/22.
 */
public class RealmHelper {

    Context context;

    public RealmHelper(Context context){
        this.context = context;
    }

    public void writteAreaDB(String areaName,String lat,String lon) {

        // Obtain a Realm instance
        Realm realm = Realm.getInstance(context);

        try{
            realm.beginTransaction();

            //同じデータがあるかチェック
            RealmQuery<AreaRealmModel> query = realm.where(AreaRealmModel.class);
            query.equalTo("areaName", areaName);

            RealmResults<AreaRealmModel> resultSearch = query.findAll();

            if(resultSearch.size() > 0){
                //NOP
            }else{
                // Create a new object
                AreaRealmModel areaModel = realm.createObject(AreaRealmModel.class);
                areaModel.setAreaName(areaName);
                areaModel.setLat(lat);
                areaModel.setLon(lon);
            }

            /******
            //５件以上なら一番下のデータを消す
            RealmResults<DriveSearchHistoryRealmModel> result = realm.where(DriveSearchHistoryRealmModel.class).findAll();
            if(result.size() > 5){
                // remove single match
                result.remove(0);
            }
            *****/
        }catch (Exception e){
            //NOP
        }finally {
            realm.commitTransaction();
        }
    }


    public RealmResults<AreaRealmModel> getAreaData(){
        // Obtain a Realm instance
        Realm realm = Realm.getInstance(context);

        // Query
        RealmResults<AreaRealmModel> result = realm.where(AreaRealmModel.class).findAll();

        if(result.size() > 0) {
            return result;
        }else{
            return null;
        }
    }

}
