#git clone -o PersonOfGameLibrary https://github.com/Kovalsky95/PersonOfGameLibrary.git
#git config --global credential.helper cache
git config --global credential.helper "cache --timeout=3600"
#git config credential.helper store
#git config --unset credential.helper
git pull --all
git add .
git commit -m PenguinL
git push --set-upstream PersonOfGameLibrary master