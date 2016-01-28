package com.yihukurama.mvc4a.model.access.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property INDEX = new Property(0, Long.class, "INDEX", true, "INDEX");
        public final static Property AICHAID = new Property(1, String.class, "AICHAID", false, "AICHAID");
        public final static Property MOBILE = new Property(2, String.class, "MOBILE", false, "MOBILE");
        public final static Property HEAD_URL = new Property(3, String.class, "HEAD_URL", false, "HEAD__URL");
        public final static Property NICKNAME = new Property(4, String.class, "NICKNAME", false, "NICKNAME");
        public final static Property EMAIL = new Property(5, String.class, "EMAIL", false, "EMAIL");
        public final static Property QRCODE = new Property(6, String.class, "QRCODE", false, "QRCODE");
        public final static Property SEX = new Property(7, String.class, "SEX", false, "SEX");
        public final static Property ZONE = new Property(8, String.class, "ZONE", false, "ZONE");
        public final static Property SIGN = new Property(9, String.class, "SIGN", false, "SIGN");
        public final static Property BIRTHDAY = new Property(10, String.class, "BIRTHDAY", false, "BIRTHDAY");
        public final static Property LIGHTS = new Property(11, String.class, "LIGHTS", false, "LIGHTS");
        public final static Property NOTICE = new Property(12, String.class, "NOTICE", false, "NOTICE");
        public final static Property GROUP_INFO = new Property(13, String.class, "GROUP_INFO", false, "GROUP__INFO");
        public final static Property SLEEP_MODE = new Property(14, String.class, "SLEEP_MODE", false, "SLEEP__MODE");
        public final static Property SHAKER = new Property(15, String.class, "SHAKER", false, "SHAKER");
        public final static Property GROUP_SHAKER = new Property(16, String.class, "GROUP_SHAKER", false, "GROUP__SHAKER");
        public final static Property SOUND = new Property(17, String.class, "SOUND", false, "SOUND");
        public final static Property GROUP_SOUND = new Property(18, String.class, "GROUP_SOUND", false, "GROUP__SOUND");
        public final static Property WARING_TONE = new Property(19, String.class, "WARING_TONE", false, "WARING__TONE");
        public final static Property VALIDATE = new Property(20, String.class, "VALIDATE", false, "VALIDATE");
        public final static Property RECOMMEND = new Property(21, String.class, "RECOMMEND", false, "RECOMMEND");
        public final static Property SEARCHBYPHONE = new Property(22, String.class, "SEARCHBYPHONE", false, "SEARCHBYPHONE");
        public final static Property HasNewFriend = new Property(23, String.class, "hasNewFriend", false, "HAS_NEW_FRIEND");
        public final static Property UserId = new Property(24, String.class, "userId", false, "USER_ID");
        public final static Property Tab1commodityHasNew = new Property(25, String.class, "tab1commodityHasNew", false, "TAB1COMMODITY_HAS_NEW");
        public final static Property Tab2trademarkHasNew = new Property(26, String.class, "tab2trademarkHasNew", false, "TAB2TRADEMARK_HAS_NEW");
        public final static Property Tab3chatHasNew = new Property(27, String.class, "tab3chatHasNew", false, "TAB3CHAT_HAS_NEW");
        public final static Property Tab4integralHasNew = new Property(28, String.class, "tab4integralHasNew", false, "TAB4INTEGRAL_HAS_NEW");
        public final static Property LastReceiveIntegral = new Property(29, String.class, "lastReceiveIntegral", false, "LAST_RECEIVE_INTEGRAL");
        public final static Property IntegralBalance = new Property(30, String.class, "integralBalance", false, "INTEGRAL_BALANCE");
        public final static Property BALANCE_USE = new Property(31, String.class, "BALANCE_USE", false, "BALANCE__USE");
        public final static Property HX_USERNAME = new Property(32, String.class, "HX_USERNAME", false, "HX__USERNAME");
        public final static Property HX_PASSWD = new Property(33, String.class, "HX_PASSWD", false, "HX__PASSWD");
        public final static Property MIN_VERSION = new Property(34, String.class, "MIN_VERSION", false, "MIN__VERSION");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'INDEX' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: INDEX
                "'AICHAID' TEXT NOT NULL UNIQUE ," + // 1: AICHAID
                "'MOBILE' TEXT," + // 2: MOBILE
                "'HEAD__URL' TEXT," + // 3: HEAD_URL
                "'NICKNAME' TEXT," + // 4: NICKNAME
                "'EMAIL' TEXT," + // 5: EMAIL
                "'QRCODE' TEXT," + // 6: QRCODE
                "'SEX' TEXT," + // 7: SEX
                "'ZONE' TEXT," + // 8: ZONE
                "'SIGN' TEXT," + // 9: SIGN
                "'BIRTHDAY' TEXT," + // 10: BIRTHDAY
                "'LIGHTS' TEXT," + // 11: LIGHTS
                "'NOTICE' TEXT," + // 12: NOTICE
                "'GROUP__INFO' TEXT," + // 13: GROUP_INFO
                "'SLEEP__MODE' TEXT," + // 14: SLEEP_MODE
                "'SHAKER' TEXT," + // 15: SHAKER
                "'GROUP__SHAKER' TEXT," + // 16: GROUP_SHAKER
                "'SOUND' TEXT," + // 17: SOUND
                "'GROUP__SOUND' TEXT," + // 18: GROUP_SOUND
                "'WARING__TONE' TEXT," + // 19: WARING_TONE
                "'VALIDATE' TEXT," + // 20: VALIDATE
                "'RECOMMEND' TEXT," + // 21: RECOMMEND
                "'SEARCHBYPHONE' TEXT," + // 22: SEARCHBYPHONE
                "'HAS_NEW_FRIEND' TEXT," + // 23: hasNewFriend
                "'USER_ID' TEXT," + // 24: userId
                "'TAB1COMMODITY_HAS_NEW' TEXT," + // 25: tab1commodityHasNew
                "'TAB2TRADEMARK_HAS_NEW' TEXT," + // 26: tab2trademarkHasNew
                "'TAB3CHAT_HAS_NEW' TEXT," + // 27: tab3chatHasNew
                "'TAB4INTEGRAL_HAS_NEW' TEXT," + // 28: tab4integralHasNew
                "'LAST_RECEIVE_INTEGRAL' TEXT," + // 29: lastReceiveIntegral
                "'INTEGRAL_BALANCE' TEXT," + // 30: integralBalance
                "'BALANCE__USE' TEXT," + // 31: BALANCE_USE
                "'HX__USERNAME' TEXT," + // 32: HX_USERNAME
                "'HX__PASSWD' TEXT," + // 33: HX_PASSWD
                "'MIN__VERSION' TEXT);"); // 34: MIN_VERSION
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long INDEX = entity.getINDEX();
        if (INDEX != null) {
            stmt.bindLong(1, INDEX);
        }
        stmt.bindString(2, entity.getAICHAID());
 
        String MOBILE = entity.getMOBILE();
        if (MOBILE != null) {
            stmt.bindString(3, MOBILE);
        }
 
        String HEAD_URL = entity.getHEAD_URL();
        if (HEAD_URL != null) {
            stmt.bindString(4, HEAD_URL);
        }
 
        String NICKNAME = entity.getNICKNAME();
        if (NICKNAME != null) {
            stmt.bindString(5, NICKNAME);
        }
 
        String EMAIL = entity.getEMAIL();
        if (EMAIL != null) {
            stmt.bindString(6, EMAIL);
        }
 
        String QRCODE = entity.getQRCODE();
        if (QRCODE != null) {
            stmt.bindString(7, QRCODE);
        }
 
        String SEX = entity.getSEX();
        if (SEX != null) {
            stmt.bindString(8, SEX);
        }
 
        String ZONE = entity.getZONE();
        if (ZONE != null) {
            stmt.bindString(9, ZONE);
        }
 
        String SIGN = entity.getSIGN();
        if (SIGN != null) {
            stmt.bindString(10, SIGN);
        }
 
        String BIRTHDAY = entity.getBIRTHDAY();
        if (BIRTHDAY != null) {
            stmt.bindString(11, BIRTHDAY);
        }
 
        String LIGHTS = entity.getLIGHTS();
        if (LIGHTS != null) {
            stmt.bindString(12, LIGHTS);
        }
 
        String NOTICE = entity.getNOTICE();
        if (NOTICE != null) {
            stmt.bindString(13, NOTICE);
        }
 
        String GROUP_INFO = entity.getGROUP_INFO();
        if (GROUP_INFO != null) {
            stmt.bindString(14, GROUP_INFO);
        }
 
        String SLEEP_MODE = entity.getSLEEP_MODE();
        if (SLEEP_MODE != null) {
            stmt.bindString(15, SLEEP_MODE);
        }
 
        String SHAKER = entity.getSHAKER();
        if (SHAKER != null) {
            stmt.bindString(16, SHAKER);
        }
 
        String GROUP_SHAKER = entity.getGROUP_SHAKER();
        if (GROUP_SHAKER != null) {
            stmt.bindString(17, GROUP_SHAKER);
        }
 
        String SOUND = entity.getSOUND();
        if (SOUND != null) {
            stmt.bindString(18, SOUND);
        }
 
        String GROUP_SOUND = entity.getGROUP_SOUND();
        if (GROUP_SOUND != null) {
            stmt.bindString(19, GROUP_SOUND);
        }
 
        String WARING_TONE = entity.getWARING_TONE();
        if (WARING_TONE != null) {
            stmt.bindString(20, WARING_TONE);
        }
 
        String VALIDATE = entity.getVALIDATE();
        if (VALIDATE != null) {
            stmt.bindString(21, VALIDATE);
        }
 
        String RECOMMEND = entity.getRECOMMEND();
        if (RECOMMEND != null) {
            stmt.bindString(22, RECOMMEND);
        }
 
        String SEARCHBYPHONE = entity.getSEARCHBYPHONE();
        if (SEARCHBYPHONE != null) {
            stmt.bindString(23, SEARCHBYPHONE);
        }
 
        String hasNewFriend = entity.getHasNewFriend();
        if (hasNewFriend != null) {
            stmt.bindString(24, hasNewFriend);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(25, userId);
        }
 
        String tab1commodityHasNew = entity.getTab1commodityHasNew();
        if (tab1commodityHasNew != null) {
            stmt.bindString(26, tab1commodityHasNew);
        }
 
        String tab2trademarkHasNew = entity.getTab2trademarkHasNew();
        if (tab2trademarkHasNew != null) {
            stmt.bindString(27, tab2trademarkHasNew);
        }
 
        String tab3chatHasNew = entity.getTab3chatHasNew();
        if (tab3chatHasNew != null) {
            stmt.bindString(28, tab3chatHasNew);
        }
 
        String tab4integralHasNew = entity.getTab4integralHasNew();
        if (tab4integralHasNew != null) {
            stmt.bindString(29, tab4integralHasNew);
        }
 
        String lastReceiveIntegral = entity.getLastReceiveIntegral();
        if (lastReceiveIntegral != null) {
            stmt.bindString(30, lastReceiveIntegral);
        }
 
        String integralBalance = entity.getIntegralBalance();
        if (integralBalance != null) {
            stmt.bindString(31, integralBalance);
        }
 
        String BALANCE_USE = entity.getBALANCE_USE();
        if (BALANCE_USE != null) {
            stmt.bindString(32, BALANCE_USE);
        }
 
        String HX_USERNAME = entity.getHX_USERNAME();
        if (HX_USERNAME != null) {
            stmt.bindString(33, HX_USERNAME);
        }
 
        String HX_PASSWD = entity.getHX_PASSWD();
        if (HX_PASSWD != null) {
            stmt.bindString(34, HX_PASSWD);
        }
 
        String MIN_VERSION = entity.getMIN_VERSION();
        if (MIN_VERSION != null) {
            stmt.bindString(35, MIN_VERSION);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // INDEX
            cursor.getString(offset + 1), // AICHAID
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // MOBILE
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // HEAD_URL
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // NICKNAME
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // EMAIL
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // QRCODE
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // SEX
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // ZONE
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // SIGN
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // BIRTHDAY
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // LIGHTS
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // NOTICE
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // GROUP_INFO
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // SLEEP_MODE
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // SHAKER
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // GROUP_SHAKER
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // SOUND
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // GROUP_SOUND
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // WARING_TONE
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // VALIDATE
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // RECOMMEND
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // SEARCHBYPHONE
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // hasNewFriend
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // userId
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // tab1commodityHasNew
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // tab2trademarkHasNew
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // tab3chatHasNew
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // tab4integralHasNew
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // lastReceiveIntegral
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // integralBalance
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // BALANCE_USE
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // HX_USERNAME
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // HX_PASSWD
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34) // MIN_VERSION
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setINDEX(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAICHAID(cursor.getString(offset + 1));
        entity.setMOBILE(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHEAD_URL(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNICKNAME(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setEMAIL(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setQRCODE(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSEX(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setZONE(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSIGN(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setBIRTHDAY(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setLIGHTS(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setNOTICE(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setGROUP_INFO(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setSLEEP_MODE(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setSHAKER(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setGROUP_SHAKER(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setSOUND(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setGROUP_SOUND(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setWARING_TONE(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setVALIDATE(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setRECOMMEND(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setSEARCHBYPHONE(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setHasNewFriend(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setUserId(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setTab1commodityHasNew(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setTab2trademarkHasNew(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setTab3chatHasNew(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setTab4integralHasNew(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setLastReceiveIntegral(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setIntegralBalance(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setBALANCE_USE(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setHX_USERNAME(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setHX_PASSWD(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setMIN_VERSION(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setINDEX(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getINDEX();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
