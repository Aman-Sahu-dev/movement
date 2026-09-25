pub struct MasterTable {
    pub subject_name: String,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}
#[derive(Debug)]
pub enum MasterTableEror {
    MissingName,
}
pub struct MasterTableBuilder {
    pub subject_name: Option<String>,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}

impl MasterTableBuilder {
    pub fn new() -> Self {
        Self {
            subject_name: None,
            subject_code: None,
            expected_classes: None,
            frequency_per_week: None,
        }
    }
    pub fn with_name(mut self, name: String) -> Self {
        self.subject_name = Some(name);
        self
    }
    pub fn with_code(mut self, code: String) -> Self {
        self.subject_code = Some(code);
        self
    }
    pub fn with_classes(mut self, classes: u32) -> Self {
        self.expected_classes = Some(classes);
        self
    }
    pub fn with_freq(mut self, freq: u32) -> Self {
        self.frequency_per_week = Some(freq);
        self
    }
    pub fn build(self) -> Result<MasterTable, MasterTableEror> {
        let name = match self.subject_name {
            Some(n) if !n.is_empty() => n,
            _ => return Err(MasterTableEror::MissingName),
        };
        Ok(MasterTable {
            subject_name: name,
            subject_code: self.subject_code,
            expected_classes: self.expected_classes,
            frequency_per_week: self.frequency_per_week,
        })
    }
}
