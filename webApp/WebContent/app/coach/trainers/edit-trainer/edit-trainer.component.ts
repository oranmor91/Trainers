import { PROGRAM } from '../../../Model/program.model';
import { DataService } from '../../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TRAINER} from "../../../Model/trainer.model";
import {PROGRAM_DEF} from "../../../Model/programDef.model";

@Component({
  selector: 'app-edit-trainer',
  templateUrl: './edit-trainer.component.html',
  styleUrls: ['./edit-trainer.component.css']
})
export class EditTrainerComponent implements OnInit {

  trainerId:string;
  trainer:TRAINER;
  program:PROGRAM;
  programs:PROGRAM_DEF[];
  arr:number[];
  chosenProgram:number;

  constructor(private dataService:DataService,
              private router: Router,
              private route: ActivatedRoute) {
    this.route.params.subscribe( params => console.log(params));
    this.route.params.subscribe(params => this.definedId(params['id']));
  }

  definedId(id: string){
    this.trainerId = id;
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
    this.dataService.getUserProgram(Number(this.trainerId))
      .subscribe((data)=> {
        this.program = <PROGRAM> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  private getAllPrograms() {
    this.dataService.getPrograms(this.trainerId)
      .subscribe((data)=> {
        this.programs = <PROGRAM_DEF[]> data;
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }

  userProgram(){
    this.router.navigate([`/trainer-program:pid${this.trainerId}`]);
  }

  checkIfExisted(p:PROGRAM_DEF){
    if(!this.program){
      return false;
    }

    if(p.id === this.program.programDefId) {
      //console.log('return true');
      return true;
    } else {
      //console.log('return false');
      return false;
    }
  }

  changeUserProgram() {
    this.dataService.setUserProgram(this.trainerId, this.programs[this.chosenProgram].id)
      .subscribe((data)=>{
        //location.reload();
      },(err)=>{
        console.log(err)
      },()=>{
        console.log('done')
      })
  }
}
