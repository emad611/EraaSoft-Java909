package com.model.service;
// هنا عملنا الوراثة بس من نوع final علشان ميعرفش حد يستدعيه سواء كلاس يورث او ميثود تعمل  override
public final class PrivateClubClassImpl implements PrivateClubPlayer {
    @Override
    //هنا هنرجع اللاعب من نوع خاص علشان كدا عملناله interface لوحده
    public Player addPlayer(Player player) {
        return player;
    }
}
