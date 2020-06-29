package kz.education.stepclasswork8.Utils

import kz.education.stepclasswork8.data.Student

fun ArrayList<Student>.getTop(){
    this.sortByDescending{ e->e.mark }
    if(this.count()>3){
        for(i in 3..this.count()-1){
            this[i].show=false;
        }
    }
}


fun ArrayList<Student>.getAll(){
    this.forEach { s->s.show=true }
}