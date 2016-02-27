package org.pacemaker.main;

public interface SyncUpdate
{
  void userSyncComplete();
  void activitiesSyncComplete();
  void syncError (Exception e);
}
