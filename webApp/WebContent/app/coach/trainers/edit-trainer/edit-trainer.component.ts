import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TRAINER} from "../../../Model/trainer.model";
import {WORKOUT} from "../../../Model/workout.model";

@Component({
  selector: 'app-edit-trainer',
  templateUrl: './edit-trainer.component.html',
  styleUrls: ['./edit-trainer.component.css']
})
export class EditTrainerComponent implements OnInit {
  trainerId:string;
  trainer:TRAINER;

  constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.trainerId = route.snapshot.params['id'];
  }

  ngOnInit() {
    this.getTrainerProfile()
  }

  private getTrainerProfile() {
    this.dataService.getTrainerProfile(this.trainerId)
      .subscribe((data)=>{
        this.trainer = <TRAINER> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  userProgram(){
    this.router.navigate(['/trainer-program:pId']);
  }
}
