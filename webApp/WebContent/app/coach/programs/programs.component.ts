import { PROGRAM_DEF } from '../../Model/programDef.model';
import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {

  programs:PROGRAM_DEF[]=[];

 constructor(private dataService:DataService,
              private router: Router) { }

 ngOnInit() {
   this.getPrograms();
  }

  getPrograms(){
    this.dataService.getPrograms(this.dataService.profile.id)
    .subscribe((data)=>{
    this.programs = <PROGRAM_DEF[]> data;
   },(err)=>{
      console.log(err)
    },()=>{
      console.log('done')
    })
  }

  createProgram(){
    this.router.navigate(['create-program']);
  }

  editProgram(id:number){
    this.router.navigate([`/edit-program/${id}`]);
  }

   removeProgram(id:number){
    this.dataService.removeProgram(id).subscribe((data)=>{
      this.getPrograms();
    },(err)=>{
      console.log(err)
   },()=>{
      console.log('done')
    })
  }
}
