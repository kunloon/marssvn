package com.svnlike.svnapi;

import com.svnlike.svnapi.model.SvnEntry;
import com.svnlike.svnapi.model.SvnLock;
import com.svnlike.svnapi.model.SvnUser;

import java.util.List;

/**
 * SVN client interface
 *
 * @author zhangkx
 */
public interface ISvnClient {

    /**
     * set root path
     *
     * @param rootPath svn root path
     */
    void setRootPath(String rootPath);

    /**
     * set svn user
     *
     * @param svnUser svn user
     */
    void setSvnUser(SvnUser svnUser);

    /**
     * make directory, will make parent directories also
     *
     * @param dirPath directory path
     * @param message message
     */
    void mkdir(String dirPath, String message);

    /**
     * get head headRevision of path
     *
     * @return head headRevision
     */
    long headRevision();

    /**
     * get last changed headRevision
     *
     * @param path path
     * @return last changed headRevision
     */
    public long lastChangedRevision(String path);

    /**
     * get file mime type
     *
     * @param filePath file path
     * @return mime type
     */
    String getMimeType(String filePath);

    /**
     * svn info
     *
     * @param path     file or directory path
     * @param revision headRevision, default is HEAD
     * @return info
     */
    String info(String path, long revision);

    /**
     * @param filePath file path
     * @param revision headRevision, default is HEAD
     * @return blame string
     */
    String blame(String filePath, long revision);

    /**
     * list directories and files of path
     *
     * @param path directory path
     * @return list
     */
    default List<SvnEntry> list(String path) {
        return list(path, -1);
    }

    /**
     * get the document list of path
     * svn command: svn list
     *
     * @param path     relative path
     * @param revision headRevision
     * @return entry list
     */
    List<SvnEntry> list(String path, long revision);

    /**
     * lock the file of path, if path is a directory, lock all of it's children file
     *
     * @param path    directory or file path
     * @param comment lock comment
     * @param force   force to steal the lock from another user or working copy
     * @return boolean
     */
    boolean lock(String path, String comment, boolean force);

    /**
     * unlock the file of path, if path is a directory, unlock all of it's children file
     *
     * @param path  directory or file path
     * @param force force to break the lock
     * @return boolean
     */
    boolean unLock(String path, boolean force);

    /**
     * get lock info of path
     *
     * @param filePath file path
     * @return SvnLock
     */
    SvnLock getLock(String filePath);

    /**
     * get file content of text file
     *
     * @param filePath file path
     * @param revision headRevision, default is HEAD
     * @return file content
     */
    String getFileContent(String filePath, long revision);

    /**
     * get file content of text file
     *
     * @param path file path
     * @return file content
     */
    default String getFileContent(String path) {
        return getFileContent(path, -1);
    }


    /**
     * moveRepository source path to dest path
     *
     * @param sourcePath source path
     * @param destPath   dest path
     * @param message    log message
     * @return boolean
     */
    boolean move(String sourcePath, String destPath, String message);

    /**
     * export exports a clean directory tree from the repository
     *
     * @param path     path
     * @param revision headRevision, default is HEAD
     * @return string
     */
    String export(String path, long revision);

    /**
     * Display local changes or differences between two revisions or paths
     *
     * @param filePath     file path
     * @param olderVersion old headRevision
     * @param newerVision  new headRevision
     * @return differences
     */
    String diff(String filePath, long olderVersion, long newerVision);


}
