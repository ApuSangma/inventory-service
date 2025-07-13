package com.InventoryManagement.model.response;

public class InventoryHealthInfo {
    private Integer activeUsers;
    private long uptimeSecond;
    private String serverStatus;

    public InventoryHealthInfo() {
    }

    public InventoryHealthInfo(Integer activeUsers, long uptimeSecond, String serverStatus) {
        this.activeUsers = activeUsers;
        this.uptimeSecond = uptimeSecond;
        this.serverStatus = serverStatus;
    }

    public Integer getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Integer activeUsers) {
        this.activeUsers = activeUsers;
    }

    public long getUptimeSecond() {
        return uptimeSecond;
    }

    public void setUptimeSecond(long uptimeSecond) {
        this.uptimeSecond = uptimeSecond;
    }

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }
}
