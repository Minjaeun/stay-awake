
class User {
    constructor(id, name, group, subjects, friends, records) {
        this.id = id;   //PK
        this.name = name;
        this.group = group; //FK
        this.subjects = subjects;  //FK
        this.friends = friends;  //FK
        this.records = records;  //FK
    }
}

class Record {
    constructor(id, subject, time, date) {
        this.id = id;
        this.subject = subject;
        this.time = time;
        this.date = date;
    }

}

class Subject {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Group {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

function createUser(id, name, group) {
    var user = new User(id, name, group);
    return user;
}

function createRecord(id, subject, time, date) {
    var record = new Record(id, subject, time, date);
    record.get();
    return record;

}
