
class User {
    constructor(id, name, group, subjects, friends, records) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.subjects = subjects;
        this.friends = friends;
        this.records = records;
    }
}

function creatUser(id, name, group){
    var user = new User();
    user.id = id;
    user.name = name;
    user.group = group;
    return user;
}
