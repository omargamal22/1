package com.example.gamal.backingapp.UI;

public class Events {
    public static class ActivityActivityMessage {
        private int message;
        public ActivityActivityMessage(int message) {
            this.message = message;
        }
        public int getMessage() {
            return message;
        }
    }
    public static class  FragmentFragmentMessage{
        private int message1 , messade2;

        public FragmentFragmentMessage(int message1, int messade2) {
            this.message1 = message1;
            this.messade2 = messade2;
        }

        public int getMessage1() {
            return message1;
        }

        public int getMessade2() {
            return messade2;
        }
    }

    public static class  FragmentNotifyMessage{
        private int Not;
        private boolean flag;

        public int getNot() {
            return Not;
        }

        public boolean isFlag() {
            return flag;
        }

        public FragmentNotifyMessage(int not, boolean flag) {

            Not = not;
            this.flag = flag;
        }
    }
}
