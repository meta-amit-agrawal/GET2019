package Question1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Command {

	Folder currentFolder;
	List<String> folders = new ArrayList<String>();



	/*
	 * @return currentFolder, in which folder you are working currently
	 * */
	public Folder getCurrentFolder() {
		return currentFolder;
	}

	/*
	 * @param currentFolder
	 * */
	public void setCurrentFolder(Folder currentFolder) {
		this.currentFolder = currentFolder;
	}

	/*
	 * @return List folder 
	 * */
	public List<String> getFolders() {
		return folders;
	}

	/*
	 * Constructor
	 * */
	public Command() {
		currentFolder = new Folder(ConstantClass.rootDirectoryName);
	}


	/*
	 * Flow of Virtual command prompt will start from here
	 *  */
	public void runVcp() {
		
		String inputCommand;
		Scanner input = new Scanner(System.in);
		while(true) {
			
			printPath();
			inputCommand = input.nextLine();

			String [] commands = inputCommand.split(" ");
			if(commands.length==1) {

				switch (commands[0]) {

				case "bk":
					bk();
					break;

				case "ls":
					ls();
					break;

				case "tree":
					tree();
					break;
					
				case "exit":
					System.exit(0);
					break;

				default:
					System.out.println("Command Not found");
				}
			}


			else if(commands.length==2) {

				switch (commands[0]) {

				case "mkdir":
					mkdir(commands[1]);
					break;

				case "cd":
					cd(commands[1]);
					break;

				case "find":
					search(commands[1]);
					break;

				default:
					System.out.println("Command Not found");
				}
			}

		}
	}




	/*
	 * @param folderName,new folder name which is going to be create in this current folder
	 * 
	 * */
	public void mkdir(String folderName) {
		boolean status = this.getCurrentFolder().mkdir(folderName);
		if(status == false) {
			System.out.println("folder already exist with same name then new folder will not create");
		}

	}

	/*
	 *  @param folderName,sub folder name  which is going to be current folder now
	 *  */
	public void cd(String folderName) {
		Folder subFolder = this.getCurrentFolder().cd(folderName);
		if(subFolder!=null) {
			this.setCurrentFolder(subFolder);
			this.folders.add(subFolder.getName());
		}else {
			System.out.println("folder doesn't exist with this name");
		}
	}

	
	/*
	 *  @param folderName,for finding folder recursively in current folder in it's sub folder as well
	 *  */
	public void search(String folderName) {
		Folder foundFolder = this.getCurrentFolder().find(folderName);
		if(foundFolder!=null) {
			String path = getPathOfFolder(foundFolder);
			System.out.println(path);
		}else {
			System.out.println("Not Found");
		}
	}

	/*
	 * @param foundFolder, for finding path of given folder
	 * @param path, path of foundFolder in string form
	 * */
	private String getPathOfFolder(Folder foundFolder) {
		Folder currentFolder = foundFolder;
		Stack<String> folders = new Stack<String>();	
		String path = new String(" ");
		while(currentFolder!=null) {
			folders.push(currentFolder.getName());
			currentFolder = currentFolder.getParent();
		}
		while(!folders.empty()) {
			path=path+"/"+folders.pop();
		}
		return path;
	}

	
	/*
	 * moving form current directory to it's parent directory 
	 * */
	public void bk() {	
		if(this.getCurrentFolder().getParent()!=null) {
			this.setCurrentFolder(this.getCurrentFolder().getParent());
			this.folders.remove(this.folders.size()-1);
		}
	}

	/*
	 * will print all the subFolder in this folder
	 * */
	public void ls() {
		List<Folder> subFolders = this.getCurrentFolder().ls();
		
		for(Folder subFolder :subFolders ) {
			System.out.println(subFolder.getDateAndTime()+"  "+subFolder.getName());
		}
	}

	public void tree() {
		printTree(this.getCurrentFolder(),0);
	
	}

	 /**
     * method to display the tree of the given directory
     * 
     * @param currentDirectory
     * @param nesting          is the level of the subfolder
     */

    private void printTree(Folder currentDirectory, int nesting) {
        for (Folder subDirectory : currentDirectory.getSubFolders()) {
            for (int i = 0; i < nesting; i++)
                System.out.print("\u2502");
            if (subDirectory.getSubFolders().size() != 0) {
                System.out.println("\u251c\u2500" + subDirectory.getName());
                printTree(subDirectory, nesting + 1);
            } else
                System.out.println("\u2514\u2500" + subDirectory.getName());
        }
    }

	/*
	 * Will print the whole path of current working directory
	 * */
	private void printPath() {
		System.out.print("R:");
		for(String folderName : this.getFolders()) {
			System.out.print("\\" + folderName );
		}
		System.out.print(">");
	}
	
	//main method
	public static void main(String [] args) {
		Command command = new Command();
		command.runVcp();
	}

}
