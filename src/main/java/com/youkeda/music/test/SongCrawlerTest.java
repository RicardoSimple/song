package com.youkeda.music.test;

import com.youkeda.music.model.Artist;
import com.youkeda.music.model.Song;
import com.youkeda.music.service.SongCrawlerService;
import com.youkeda.music.service.impl.SongCrawlerServiceImpl;

/**
 * 检查服务是否可以正确返回对象
 */
public class SongCrawlerTest {

  private static final String A_ID = "33184";
  private static final String S_ID = "1885131100";

  public static void main(String[] args) {
    SongCrawlerService songService = new SongCrawlerServiceImpl();
    songService.start(A_ID);

    Artist artist = songService.getArtist(A_ID);
    System.out.println("歌单名称：" + artist.getName());
    Song song = songService.getSong(A_ID, S_ID);
    System.out.println("歌曲音乐为文件地址：" + song.getSourceUrl());
    System.out.println("歌曲名称：" + song.getName());
    System.out.println("歌曲所属专辑名称：" + song.getAlbum().getName());
    System.out.println("歌曲的歌手名称：" + song.getSingers().get(0).getNickName());

    System.out.println("歌曲热门评论：" + song.getHotComments().get(0).getContent());
  }
}
