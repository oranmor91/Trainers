import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TRAINER} from "../../../Model/trainer.model";
import {PROGRAM} from "../../../Model/program.model";

@Component({
  selector: 'app-edit-trainer',
  templateUrl: './edit-trainer.component.html',
  styleUrls: ['./edit-trainer.component.css']
})
export class EditTrainerComponent implements OnInit {

  trainerId:string;
  trainer:TRAINER;
  program:PROGRAM = null;
  programs:PROGRAM[] = [];
  arr:number[];
  chosenProgram:PROGRAM;

  constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.trainerId = route.snapshot.params['id'];
  }

  ngOnInit() {
    this.getTrainerProfile();
    this.getTrainerProgram();
    this.getAllPrograms();
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

  private getTrainerProgram() {
    this.dataService.getProgram(Number(this.trainerId))
      .subscribe((data)=> {
        if (data != null) {
        this.program = <PROGRAM> data;
      }
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  private getAllPrograms() {
    this.dataService.getPrograms(this.trainerId)
      .subscribe((data)=> {
        this.programs = <PROGRAM[]> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  userProgram(){
    this.router.navigate([`/trainer-program:pid${this.trainerId}`]);
  }

  checkIfExisted(p:PROGRAM){
    if(!this.programs || this.programs.length == 0){
      console.log('no programs found');
      return false;
    }

    this.arr = this.programs.map(pro => pro.id);

    if(this.arr.includes(p.id)) {
      //console.log('return true');
      return true;
    } else {
      //console.log('return false');
      return false;
    }
  }

  changeUserProgram() {
    this.dataService.setUserProgram(this.trainerId, this.chosenProgram)
      .subscribe((data)=>{
        location.reload();
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }
}
