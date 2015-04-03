package tw.skyarrow.ehreader.model;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import tw.skyarrow.ehreader.model.Photo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PHOTO.
*/
public class PhotoDao extends AbstractDao<Photo, Long> {

    public static final String TABLENAME = "PHOTO";

    /**
     * Properties of entity Photo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Page = new Property(1, int.class, "page", false, "PAGE");
        public final static Property Token = new Property(2, String.class, "token", false, "TOKEN");
        public final static Property Bookmarked = new Property(3, Boolean.class, "bookmarked", false, "BOOKMARKED");
        public final static Property Filename = new Property(4, String.class, "filename", false, "FILENAME");
        public final static Property Width = new Property(5, Integer.class, "width", false, "WIDTH");
        public final static Property Height = new Property(6, Integer.class, "height", false, "HEIGHT");
        public final static Property Src = new Property(7, String.class, "src", false, "SRC");
        public final static Property Downloaded = new Property(8, Boolean.class, "downloaded", false, "DOWNLOADED");
        public final static Property Invalid = new Property(9, Boolean.class, "invalid", false, "INVALID");
        public final static Property RetryId = new Property(10, String.class, "retryId", false, "RETRY_ID");
        public final static Property GalleryId = new Property(11, long.class, "galleryId", false, "GALLERY_ID");
    };

    private Query<Photo> gallery_PhotosQuery;

    public PhotoDao(DaoConfig config) {
        super(config);
    }
    
    public PhotoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PHOTO' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'PAGE' INTEGER NOT NULL ," + // 1: page
                "'TOKEN' TEXT NOT NULL ," + // 2: token
                "'BOOKMARKED' INTEGER," + // 3: bookmarked
                "'FILENAME' TEXT," + // 4: filename
                "'WIDTH' INTEGER," + // 5: width
                "'HEIGHT' INTEGER," + // 6: height
                "'SRC' TEXT," + // 7: src
                "'DOWNLOADED' INTEGER," + // 8: downloaded
                "'INVALID' INTEGER," + // 9: invalid
                "'RETRY_ID' TEXT," + // 10: retryId
                "'GALLERY_ID' INTEGER NOT NULL );"); // 11: galleryId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PHOTO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Photo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPage());
        stmt.bindString(3, entity.getToken());
 
        Boolean bookmarked = entity.getBookmarked();
        if (bookmarked != null) {
            stmt.bindLong(4, bookmarked ? 1l: 0l);
        }
 
        String filename = entity.getFilename();
        if (filename != null) {
            stmt.bindString(5, filename);
        }
 
        Integer width = entity.getWidth();
        if (width != null) {
            stmt.bindLong(6, width);
        }
 
        Integer height = entity.getHeight();
        if (height != null) {
            stmt.bindLong(7, height);
        }
 
        String src = entity.getSrc();
        if (src != null) {
            stmt.bindString(8, src);
        }
 
        Boolean downloaded = entity.getDownloaded();
        if (downloaded != null) {
            stmt.bindLong(9, downloaded ? 1l: 0l);
        }
 
        Boolean invalid = entity.getInvalid();
        if (invalid != null) {
            stmt.bindLong(10, invalid ? 1l: 0l);
        }
 
        String retryId = entity.getRetryId();
        if (retryId != null) {
            stmt.bindString(11, retryId);
        }
        stmt.bindLong(12, entity.getGalleryId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Photo readEntity(Cursor cursor, int offset) {
        Photo entity = new Photo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // page
            cursor.getString(offset + 2), // token
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // bookmarked
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // filename
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // width
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // height
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // src
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // downloaded
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0, // invalid
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // retryId
            cursor.getLong(offset + 11) // galleryId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Photo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPage(cursor.getInt(offset + 1));
        entity.setToken(cursor.getString(offset + 2));
        entity.setBookmarked(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setFilename(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWidth(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setHeight(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setSrc(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDownloaded(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setInvalid(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setRetryId(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setGalleryId(cursor.getLong(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Photo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Photo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "photos" to-many relationship of Gallery. */
    public List<Photo> _queryGallery_Photos(long galleryId) {
        synchronized (this) {
            if (gallery_PhotosQuery == null) {
                QueryBuilder<Photo> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GalleryId.eq(null));
                queryBuilder.orderRaw("PAGE ASC");
                gallery_PhotosQuery = queryBuilder.build();
            }
        }
        Query<Photo> query = gallery_PhotosQuery.forCurrentThread();
        query.setParameter(0, galleryId);
        return query.list();
    }

}
